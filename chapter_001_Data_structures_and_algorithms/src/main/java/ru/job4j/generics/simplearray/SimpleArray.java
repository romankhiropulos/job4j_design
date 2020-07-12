package ru.job4j.generics.simplearray;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private final Object[] storage;

    private final int capacity;

    private int indexCounter = -1;

    public SimpleArray(int capacity) {
        this.capacity = capacity;
        storage = new Object[capacity];
    }

    public void add(T element) {
        Objects.checkIndex(indexCounter + 1, capacity);
        indexCounter++;
        storage[indexCounter] = element;
    }

    public T get(int index) {
        Objects.checkIndex(index, indexCounter + 1);
        return (T) storage[index];
    }

    public void set(int index, T element) {
        Objects.checkIndex(index, indexCounter + 1);
        storage[index] = element;
    }

    public void remove(int index) {
        Objects.checkIndex(index, indexCounter + 1);
        System.arraycopy(storage, index + 1, storage, index, indexCounter - index - 1);
        indexCounter--;
    }

    public int getIndexCounter() {
        return indexCounter + 1;
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleItr();
    }

    public int size() {
        return indexCounter + 1;
    }

    private class SimpleItr implements Iterator<T> {

        private int point = 0;

        public SimpleItr() {
        }

        @Override
        public boolean hasNext() {
            return point <= indexCounter;
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
