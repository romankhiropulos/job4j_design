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
        tree.add(5, 6);
        assertThat(tree.findBy(6).isPresent(), is(true));
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