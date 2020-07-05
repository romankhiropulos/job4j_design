package ru.job4j.iterators;

import java.util.*;

public class FlatMap<T> implements Iterator<T> {
    private final Iterator<Iterator<T>> data;
    private Iterator<T> iterator = Collections.emptyIterator();

    public FlatMap(Iterator<Iterator<T>> data) {
        this.data = Objects.requireNonNull(data, "data must not be null");
        iterator = data.next();
    }

    @Override
    public boolean hasNext() {
        while (data.hasNext() && !iterator.hasNext()) {
            iterator = data.next();
        }
        return iterator.hasNext();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return iterator.next();
    }

    public static void main(String[] args) {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1, 2, 3, 4).iterator(),
                List.of(5, 6).iterator(),
                List.of(7, 8, 9).iterator()
        ).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        while (flat.hasNext()) {
            System.out.println(flat.next());
        }
    }
}
