package ru.job4j.set;

import ru.job4j.generics.simplearray.SimpleArray;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleArray<T> storage;

    public SimpleSet(int capacity) {
        storage = new SimpleArray<>(capacity);
    }

    public int size() {
        return storage.size();
    }

    public void add(T item) {
        if (validate(storage, item)) {
            storage.add(item);
        }
    }

    private boolean validate(SimpleArray<T> storage, T item) {
        for (T current : storage) {
            if (Objects.equals(item, current)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return storage.iterator();
    }
}
