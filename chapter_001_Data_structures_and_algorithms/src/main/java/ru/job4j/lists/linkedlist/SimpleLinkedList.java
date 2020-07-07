package ru.job4j.lists.linkedlist;

import java.util.*;

public class SimpleLinkedList<T> implements Iterable<T> {
    private int modCount;
    private int size;

    private Node<T> first;
    private Node<T> last;

    public SimpleLinkedList() {
    }

    public void add(T element) {
        Node<T> oldTail = last;
        Node<T> newTail = new Node<>(element, oldTail, null);
        last = newTail;
        if (first != null) {
            oldTail.next = newTail;
        } else {
            first = newTail;
        }
        size++;
        modCount++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        Iterator<T> iterator = this.iterator();
        Object[] searchValue = new Object[]{null};
        int[] array = {0};
        iterator.forEachRemaining(nextValue -> {
            if (array[0] == index) {
                searchValue[0] = nextValue;
                return;
            }
            array[0]++;
        });

        return (T) searchValue[0];
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private static class Node<T> {

        T obj;
        Node<T> previous;
        Node<T> next;

        public Node(T obj) {
            this.obj = obj;
        }

        public Node(T obj, Node<T> previous, Node<T> next) {
            this(obj);
            this.previous = previous;
            this.next = next;
        }
    }

    private class Itr implements Iterator<T> {
        private Node<T> lastReturned;
        private Node<T> next;
        int expectedModCount = modCount;
        int point;

        public Itr() {
            next = first;
        }

        @Override
        public boolean hasNext() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return point < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (point != 0) {
                next = lastReturned.next;
                lastReturned = next;
            } else {
                lastReturned = first;
                next = first;
            }
            point++;
            return (T) next;
        }
    }
}
