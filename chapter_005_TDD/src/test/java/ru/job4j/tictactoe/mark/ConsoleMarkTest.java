package ru.job4j.tictactoe.mark;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ConsoleMarkTest {
    @Test
    public void print() {
        String message = "Game Over!";
        Mark<OutputStream> mark = new ConsoleMark(message);
        var out = new ByteArrayOutputStream();
        mark.print(out);
        assertThat(out.toString(), is(message));
    }
}