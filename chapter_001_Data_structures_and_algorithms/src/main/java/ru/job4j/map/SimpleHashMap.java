package ru.job4j.map;

import java.util.*;

/**
 * Ассоциативный массив на базе хэш-таблицы должен быть унифицирован через генерики и иметь методы:
 * boolean insert(K key, V value);
 * V get(K key);
 * boolean delete(K key);
 * <p>
 * Реализовывать итератор.
 * <p>
 * Внутренняя реализация должна использовать массив. Нужно обеспечить фиксированное время вставки
 * и получение. Предусмотрите возможность роста хэш-таблицы при нехватке места для нового элемента.
 * <p>
 * Методы разрешения коллизий реализовывать не надо.
 * Например: если при добавлении ключ уже есть, то возвращать false.
 */
public class SimpleHashMap<K, V> implements Iterable<SimpleHashMap.Node<K, V>> {

    private int capacity = 64;

    private Node<K, V>[] table = (Node<K, V>[]) new Node[capacity];

    private int size;

    private float loadFactor = 0.75f;

    private int modCount;

    private int threshold;

    public SimpleHashMap() {
        threshold = makeThreshold();
    }

    private int makeThreshold() {
        return (int) (table.length * loadFactor);
    }

    boolean isEmptyBucket(int hash) {
        return table[(table.length - 1) & hash] == null;
    }

    private int getIndex(int hash) {
        return (table.length - 1) & hash;
    }

    boolean insert(K key, V value) {
        int hash = hash(key);
        int index = getIndex(hash);
        if (isEmptyBucket(hash)) {
            table[index] = new Node<>(hash, key, value);
            size++;
            modCount++;
            if (size > threshold) {
                resize();
            }
            return true;
        } else if (table[index].key == null) {
            table[index].value = value;
            return true;
        } else if (table[index].key == key || table[index].key.equals(key)) {
            table[index].value = value;
            return true;
        }
        return false;
    }

    private void resize() {
        Node<K, V>[] oldTable = table;
        capacity = 2 * capacity;
        table = (Node<K, V>[]) new Node[capacity];
        threshold = makeThreshold();
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] != null) {
                table[getIndex(hash(oldTable[i].key))] = oldTable[i];
            }
        }
        modCount++;
    }

    V get(K key) {
        Node<K, V> current = table[getIndex(hash(key))];
        if (!isEmptyBucket(hash(key)) && current.key != null) {
            if (current.hash == hash(key) && current.key.equals(key)) {
                return current.value;
            }
        } else if (!isEmptyBucket(hash(key)) && current.key == null && key == null) {
            return current.value;
        }
        return null;
    }

    boolean delete(K key) {
        Node<K, V> current = table[getIndex(hash(key))];
        if (!isEmptyBucket(hash(key)) && current.key != null) {
            if (current.hash == hash(key) && current.key.equals(key)) {
                return doDelete(key);
            }
        } else if (!isEmptyBucket(hash(key)) && current.key == null && key == null) {
            return doDelete(null);
        }
        return false;
    }

    boolean doDelete(K key) {
        table[getIndex(hash(key))] = null;
        size--;
        modCount++;
        return true;
    }

    static final int hash(Object key) {
        int h = 0;
        if (key != null) {
            h = key.hashCode();
        }
        return (key == null) ? 0 : h ^ (h >>> 16);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getModCount() {
        return modCount;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<Node<K, V>> iterator() {
        return new SimpleItr();
    }

    private class SimpleItr implements Iterator<Node<K, V>> {

        private final int expectedModCount = modCount;

        private int point = 0;

        private Node<K, V>[] iterTable;

        public SimpleItr() {
        }

        @Override
        public boolean hasNext() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (iterTable == null) {
                iterTable = (Node<K, V>[]) new Node[size];
                int iterTableIndex = 0;
                for (int i = 0; i < table.length; i++) {
                    if (table[i] != null) {
                        iterTable[iterTableIndex] = table[i];
                        iterTableIndex++;
                    }
                }
            }
            return point < size;
        }

        @Override
        public Node<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return iterTable[point++];
        }
    }

    static class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        V value;

        public Node(K key, V value) {
            this.hash = hash(key);
            this.key = key;
            this.value = value;
        }

        Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final String toString() {
            return key + "=" + value;
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Node<?, ?> node = (Node<?, ?>) o;

            if (hash != node.hash) {
                return false;
            }
            if (!Objects.equals(key, node.key)) {
                return false;
            }
            return Objects.equals(value, node.value);
        }
    }
}
