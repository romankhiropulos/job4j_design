package ru.job4j.lists.linkedlist;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleLinkedListTest {
    @Test
    public void whenAddThenGet() {
        SimpleLinkedList<String> array = new SimpleLinkedList<>();
        array.add("first");
        String rsl = array.get(0);
        assertThat(rsl, is("first"));
    }

    @Test
    public void whenAddThenIt() {
        SimpleLinkedList<String> array = new SimpleLinkedList<>();
        array.add("first");
        String rsl = array.iterator().next();
        assertThat(rsl, is("first"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmpty() {
        SimpleLinkedList<String> array = new SimpleLinkedList<>();
        array.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutBound() {
        SimpleLinkedList<String> array = new SimpleLinkedList<>();
        array.add("first");
        array.get(1);
    }

    @Test
    public void whenGetThirdObject() {
        SimpleLinkedList<String> array = new SimpleLinkedList<>();
        array.add("first");
        array.add("second");
        array.add("third");
        assertThat("third", is(array.get(2)));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleLinkedList<String> array = new SimpleLinkedList<>();
        array.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleLinkedList<String> array = new SimpleLinkedList<>();
        array.add("first");
        Iterator<String> it = array.iterator();
        array.add("second");
        it.next();
    }
}