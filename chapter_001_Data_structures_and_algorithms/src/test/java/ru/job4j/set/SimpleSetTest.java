package ru.job4j.set;

import org.junit.Test;
import ru.job4j.generics.store.exceptions.NotExistStorageException;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test(expected = NoSuchElementException.class)
    public void whenAddEqualsItemThenIterate() {
        SimpleSet<Integer> set = new SimpleSet<>(10);
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(5);
        set.add(5);
        set.add(5);
        assertThat(set.size(), is(5));
        Iterator<Integer> iterator = set.iterator();
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.next(), is(5));
        assertThat(iterator.next(), is(5));
    }

    @Test
    public void whenAddSameThenFalse() {
        SimpleSet<String> set = new SimpleSet<>(10);
        set.add("first");
        set.add("first");
        assertEquals(1, set.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenSetEmpty() {
        SimpleSet<Integer> set = new SimpleSet<>(10);
        assertThat(set.size(), is(0));
        Iterator<Integer> iterator = set.iterator();
        assertThat(iterator.hasNext(), is(false));
        iterator.next();
    }
}