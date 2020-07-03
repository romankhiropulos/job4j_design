package ru.job4j.generics.simplearray;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static java.util.Optional.*;

public class SimpleArrayTest {

    private SimpleArray<Integer> simpleArray;

    @Before
    public void setUp() {
        simpleArray = new SimpleArray<>(10);
        simpleArray.add(11);
        simpleArray.add(22);
        simpleArray.add(33);
    }

    @Test
    public void add() {
        simpleArray.add(44);
        assertSize(4);
        assertEquals(of(44).get(), ofNullable(simpleArray.get(3)).get());
    }

    @Test
    public void get() {
        assertEquals(of(33).get(), ofNullable(simpleArray.get(2)).get());
        assertEquals(of(22).get(), ofNullable(simpleArray.get(1)).get());
        assertEquals(of(11).get(), ofNullable(simpleArray.get(0)).get());
    }

    @Test
    public void set() {
        simpleArray.set(1, 222);
        assertEquals(of(222).get(), ofNullable(simpleArray.get(1)).get());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void remove() {
        simpleArray.remove(2);
        assertSize(2);
        simpleArray.get(33);
    }

    @Test
    public void whenReadSequence() {
        Iterator<Integer> iterator = simpleArray.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertEquals(of(11).get(), ofNullable(iterator.next()).get());
        assertEquals(of(22).get(), ofNullable(iterator.next()).get());
        assertEquals(of(33).get(), ofNullable(iterator.next()).get());
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void whenMultiCallHasNextThenTrue() {
        Iterator<Integer> iterator = simpleArray.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
    }

    private void assertSize(int size) {
        assertEquals(size, simpleArray.getIndexCounter());
    }
}