package ru.job4j.generics.simplearray;

import org.junit.Before;
import org.junit.Test;

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

    }

    @Test
    public void set() {

    }

    @Test //(expected = NotExistStorageException.class)
    public void remove() {
        simpleArray.remove(2);
        assertSize(2);
//        simpleArray.get(UUID_2);
    }

    @Test
    public void iterator() {

    }

    private void assertSize(int size) {
        assertEquals(size, simpleArray.getIndexCounter());
    }

//    private void assertGet(int r) {
//        int n = simpleArray.get(r);
//        assertEquals(r, n);
//    }
}