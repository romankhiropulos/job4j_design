package ru.job4j.set;

import ru.job4j.generics.simplearray.SimpleArray;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleArray<T> storage;

    public SimpleSet(int capacity) {
        storage = new SimpleArray<>(capacity);
    }

    public int size() {
        return storage.size();
    }

    public boolean add(T item) {
        for (T current : storage) {
            if (item.equals(current)) {
                return false;
            }
        }
        storage.add(item);
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return storage.iterator();
    }
}
