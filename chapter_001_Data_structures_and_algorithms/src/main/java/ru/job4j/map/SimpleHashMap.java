package ru.job4j.map;

import java.util.Map;
import java.util.Objects;

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
public class SimpleHashMap<K, V> {

    private Node<K, V>[] table;

    private int size;

    private float loadFactor;

    private int modCount;

    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int threshold;

    public SimpleHashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    boolean insert(K key, V value) {
        return false;
    }

    V get(K key) {
        return null;
    }

    boolean delete(K key) {
        return false;
    }

    static final int hash(Object key) {
        int h = 0;
        if (key != null) {
            h = key.hashCode();
        }
        return (key == null) ? 0 : h ^ (h >>> 16);
    }

    static class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
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

        public final boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o instanceof Map.Entry) {
                Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
                if (Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue())) {
                    return true;
                }
            }
            return false;
        }
    }
}
