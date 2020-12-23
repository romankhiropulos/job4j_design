package ru.job4j.tictactoe;

import org.junit.Test;
import ru.job4j.tictactoe.mark.ConsoleMarkX;

import java.io.ByteArrayOutputStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConsoleMarkXTest {
    @Test
    public void print() {
        var out = new ByteArrayOutputStream();
        new ConsoleMarkX().print(out);
        assertThat(out.toString(), is("X"));
    }
}