package ru.job4j.tictactoe.mark;

import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ConsoleMarkTest {
    @Test
    public void print() {
        var out = new ByteArrayOutputStream();
        new ConsoleMark("0").print(out);
        assertThat(out.toString(), is("0"));
    }
}