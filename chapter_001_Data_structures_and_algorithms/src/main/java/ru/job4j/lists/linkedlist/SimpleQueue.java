package ru.job4j.lists.linkedlist;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        T value = in.pop();
        if (value == null) {
            throw new NoSuchElementException();
        }
        while (value != null) {
            out.push(value);
            value = in.pop();
        }
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
    }
}
