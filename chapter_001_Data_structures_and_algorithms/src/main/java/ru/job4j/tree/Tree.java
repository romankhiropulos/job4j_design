package ru.job4j.tree;

import java.util.*;

/**
 * В классе ru.job4j.tree.Tree уже реализован метод findBy.
 * Это класс использует алгоритм обхода в ширину.
 * В этом задании мы не будем касаться устройства работы этого алгоритма.
 * Вам нужно воспользоваться результатом его работы для реализации метода add.
 *
 * @param <E>
 */
class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> currentRoot = findBy(parent);
        return currentRoot.isPresent()
                && findBy(child).isEmpty()
                && getChildren(currentRoot.get()).add(new Node<>(child));
    }

    /**
     * Метод должен циклически пройти по всем элементам дерева, аналогично методу findBy
     */
    public boolean isBinary() {
        Queue<Node<E>> data = getAndOfferData();
        Node<E> element = getNextAndFillData(data);
        while (!data.isEmpty() && getSize(element) <= 2) {
            element = getNextAndFillData(data);
        }
        return getSize(element) <= 2;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Queue<Node<E>> data = getAndOfferData();
        Node<E> element;
        while (!data.isEmpty()) {
            element = getNextAndFillData(data);
            if (element.getValue().equals(value)) {
                return Optional.of(element);
            }
        }
        return Optional.empty();
    }

    private Node<E> getNextAndFillData(Queue<Node<E>> data) {
        Node<E> element = data.poll();
        data.addAll(getChildren(element));
        return element;
    }

    private Queue<Node<E>> getAndOfferData() {
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        return data;
    }

    private List<Node<E>> getChildren(Node<E> element) {
        return Objects.requireNonNull(element).getChildren();
    }

    private int getSize(Node<E> element) {
        return getChildren(element).size();
    }
}
