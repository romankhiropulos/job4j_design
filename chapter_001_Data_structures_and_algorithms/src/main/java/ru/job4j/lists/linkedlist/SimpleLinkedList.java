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
        T next = null;
        for (int i = 0; i < size; i++) {
            next = iterator.next();
            if (i == index) {
                return next;
            }
        }
        return next;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private static class Node<T> {

        private T obj;
        private Node<T> previous;
        private Node<T> next;

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
        private Node<T> current = first;
        int expectedModCount = modCount;

        public Itr() {
        }

        @Override
        public boolean hasNext() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (current.next != null) {
                current = current.next;
            }
            return current.obj;
        }
    }
}
