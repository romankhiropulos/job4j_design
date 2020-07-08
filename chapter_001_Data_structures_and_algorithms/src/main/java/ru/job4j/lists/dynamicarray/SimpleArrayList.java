package ru.job4j.lists.dynamicarray;

import java.util.*;

/**
 * The iterators returned by this class's iterator methods are fail-fast:
 * if the list is structurally modified (A structural modification is any operation
 * that adds or deletes one or more elements, or explicitly resizes the backing array;
 * merely setting the value of an element is not a structural modification.) at any
 * time after the iterator is created, in any
 * way except through the iterator's own remove or add methods, the iterator will throw
 * a ConcurrentModificationException.
 *
 * @param <T>
 * @see java.util.ArrayList
 */
public class SimpleArrayList<T> implements Iterable<T> {

    private Object[] storage;

    private int capacity = 10;

    private int elementsCounter;

    private int modCount;

    public SimpleArrayList() {
        storage = new Object[capacity];
    }

    public SimpleArrayList(int capacity) {
        if (!(capacity > 0)) {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
        this.capacity = capacity;
        storage = new Object[capacity];
    }

    public int getElementsCounter() {
        return elementsCounter;
    }

    public void add(T element) {
        if (elementsCounter == capacity) {
            capacity = 3 * capacity / 2;
            storage = Arrays.copyOf(storage, capacity);
            modCount++;
        }
        storage[elementsCounter] = element;
        elementsCounter++;
        modCount++;
    }

    public T get(int index) {
        Objects.checkIndex(index, elementsCounter);
        return (T) storage[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleItr();
    }

    private class SimpleItr implements Iterator<T> {

        private final int expectedModCount = modCount;

        private int point = 0;

        public SimpleItr() {
        }

        @Override
        public boolean hasNext() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return point < elementsCounter;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (T) storage[point++];
        }
    }
}
