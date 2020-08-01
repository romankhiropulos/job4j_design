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
        Optional<Node<E>> root = findBy(parent);
        if (root.isPresent()) {
            root.get().getChildren().add(new Node<>(child));
            return true;
        }
        return false;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> result = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.getValue().equals(value)) {
                result = Optional.of(el);
                break;
            }
            data.addAll(el.getChildren());
        }
        return result;
    }
}
