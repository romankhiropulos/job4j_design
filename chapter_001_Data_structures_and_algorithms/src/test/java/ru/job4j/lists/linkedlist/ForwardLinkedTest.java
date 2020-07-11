package ru.job4j.lists.linkedlist;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class ForwardLinkedTest {

    @Test
    public void deleteLast() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        assertThat(linked.deleteLast(), is(3));
        assertThat(linked.deleteLast(), is(2));
        assertThat(linked.deleteLast(), is(1));
        assertNull(linked.deleteLast());
    }
}