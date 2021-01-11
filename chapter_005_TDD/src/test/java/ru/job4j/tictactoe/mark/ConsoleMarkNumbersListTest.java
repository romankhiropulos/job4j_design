package ru.job4j.tictactoe.mark;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ConsoleMarkNumbersListTest {

    @Test
    public void print() {
        ConsoleMark mark = new ConsoleMarkNumbersList();
        String message = mark.getMessage();
        var out = new ByteArrayOutputStream();
        mark.print(out);
        assertThat(out.toString(), is(message));
    }
}