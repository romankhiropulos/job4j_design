package ru.job4j.lists.dynamicarray;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayListTest {
    @Test
    public void whenAddThenGet() {
        SimpleArrayList<String> array = new SimpleArrayList<>();
        array.add("first");
        String rsl = array.get(0);
        assertThat(rsl, is("first"));
    }

    @Test
    public void whenAddThenIt() {
        SimpleArrayList<String> array = new SimpleArrayList<>();
        array.add("first");
        String rsl = array.iterator().next();
        assertThat(rsl, is("first"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmpty() {
        SimpleArrayList<String> array = new SimpleArrayList<>();
        array.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutBound() {
        SimpleArrayList<String> array = new SimpleArrayList<>();
        array.add("first");
        array.get(1);
    }

    @Test
    public void whenGetThirdObject() {
        SimpleArrayList<String> array = new SimpleArrayList<>();
        array.add("first");
        array.add("second");
        array.add("third");
        assertThat("third", is(array.get(2)));
    }

    @Test
    public void whenGetFromArrayWithCustomCapacity() {
        SimpleArrayList<String> array = new SimpleArrayList<>(3);
        array.add("first");
        array.add("second");
        array.add("third");
        assertThat("third", is(array.get(2)));
        array.add("fourth");
        assertThat("fourth", is(array.get(3)));
        assertThat("first", is(array.iterator().next()));
        assertThat(4, is(array.getElementsCounter()));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleArrayList<String> array = new SimpleArrayList<>();
        array.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleArrayList<String> array = new SimpleArrayList<>();
        array.add("first");
        Iterator<String> it = array.iterator();
        array.add("second");
        it.next();
    }
}