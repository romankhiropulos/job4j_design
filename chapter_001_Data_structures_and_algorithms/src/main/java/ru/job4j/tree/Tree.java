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
        if (currentRoot.isPresent()) {
            for (Node<E> item : currentRoot.get().getChildren()) {
                if (Objects.equals(item.getValue(), child)) {
                    return false;
                }
            }
            currentRoot.get().getChildren().add(new Node<>(child));
            return true;
        }
        return false;
    }

    /**
     * Метод должен циклически пройти по всем элементам дерева, аналогично методу findBy
     *
     */
    public boolean isBinary() {
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        Node<E> element = data.poll();
        int size = Objects.requireNonNull(element).getChildren().size();
        data.addAll(Objects.requireNonNull(element).getChildren());
        while (!data.isEmpty() && size <= 2) {
            element = data.poll();
            size = Objects.requireNonNull(element).getChildren().size();
            data.addAll(Objects.requireNonNull(element).getChildren());
        }
        return size <= 2;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> result = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> element = data.poll();
            if (element.getValue().equals(value)) {
                result = Optional.of(element);
                break;
            }
            data.addAll(element.getChildren());
        }
        return result;
    }
}
