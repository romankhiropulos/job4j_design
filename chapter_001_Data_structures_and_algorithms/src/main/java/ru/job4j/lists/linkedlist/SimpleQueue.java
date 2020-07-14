package ru.job4j.lists.linkedlist;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    private void exchange(SimpleStack<T> in, SimpleStack<T> out) {
        T value = in.pop();
        if (value == null) {
            return;
        }
        while (value != null) {
            out.push(value);
            value = in.pop();
        }
    }

    public T poll() {
        T result = out.pop();
        if (result == null) {
            exchange(in, out);
            result = out.pop();
        }
        if (result == null) {
            throw new NoSuchElementException();
        }
        return result;
    }

    public void push(T value) {
        in.push(value);
    }
}
