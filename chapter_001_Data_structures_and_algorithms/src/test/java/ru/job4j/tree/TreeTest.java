package ru.job4j.tree;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(4, 6);
        tree.add(5, 7);
        assertThat(tree.findBy(6).isPresent(), is(true));
    }

    @Test
    public void whenTreeIsNotBinaryThenFalse() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(2, 4);
        tree.add(2, 5);
        tree.add(2, 6);
        tree.add(4, 7);
        assertThat(tree.isBinary(), is(false));
    }

    @Test
    public void whenTreeIsBinaryThenTrue() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(3, 4);
        tree.add(4, 5);
        tree.add(4, 6);
        assertThat(tree.isBinary(), is(true));
    }

    @Test
    public void whenChildAlreadyContainsThenFalse() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(2, 3);
        tree.add(2, 4);
        assertThat(tree.add(1, 2), is(false));
        assertThat(tree.add(2, 3), is(false));
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(tree.findBy(7).isPresent(), is(false));
    }

    @Test(expected = NullPointerException.class)
    public void whenRootNullThenNPE() {
        Tree<Integer> tree = new Tree<>(null);
        tree.add(null, 2);
        assertThat(tree.findBy(null).isPresent(), is(true));
    }

    @Test(expected = NullPointerException.class)
    public void whenChildNullValueThenNPE() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, null);
    }
}