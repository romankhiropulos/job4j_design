package ru.job4j.lists.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public T deleteLast() {
        if (head == null) {
            return null;
        }
        Node<T> tail = head;
        Node<T> preTail = head;
        T firstOut = tail.value;
        if (head.next == null) {
            firstOut = head.value;
            head = null;
            return firstOut;
        }
        while (tail.next != null) {
            tail = tail.next;
            if (tail.next == null) {
                firstOut = tail.value;
                preTail.next = null;
                break;
            }
            preTail = tail;
        }
        return firstOut;
    }

    public void deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        head = head.next;
    }

    public void revert() {
        Node<T> before = null;
        Node<T> temporary = head;
        Node<T> next;
        while (temporary != null) {
            next = temporary.next;
            temporary.next = before;
            before = temporary;
            temporary = next;
        }
        head = before;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
