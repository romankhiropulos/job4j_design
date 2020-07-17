package ru.job4j.lists.linkedlist;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private int inCount;
    private int outCount;
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    private void exchange(SimpleStack<T> in, SimpleStack<T> out) {
        while (inCount != 0) {
            inCount--;
            outCount++;
            out.push(in.pop());
        }
    }

    public T poll() {
        if (outCount == 0 && inCount == 0) {
            throw new NoSuchElementException();
        }
        if (outCount == 0) {
            exchange(in, out);
        }
        outCount--;
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        inCount++;
    }
}
