package ru.job4j.iterators;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class FlatMap<T> implements Iterator<T> {
    private final Iterator<Iterator<T>> data;
    private Iterator<T> iterator;

    public FlatMap(Iterator<Iterator<T>> data) {
        this.data = Objects.requireNonNull(data, "data must not be null");
        iterator = data.next();
    }

    @Override
    public boolean hasNext() {
        if (data.hasNext() && iterator.hasNext()) {
            return true;
        } else if (data.hasNext()) {
            iterator = data.next();
            while (!iterator.hasNext()) {
                iterator = data.next();
            }
            return true;
        } else if (iterator.hasNext()) {
            return true;
        }
        return false;
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
