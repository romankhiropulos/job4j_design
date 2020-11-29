package ru.job4j.tictactoe;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import ru.job4j.tictactoe.mark.ConsoleMarkX;

import java.io.ByteArrayOutputStream;

public class ConsoleMarkXTest {

    @Test
    public void print() {
        var out = new ByteArrayOutputStream();
        new ConsoleMarkX().print(out);
        assertThat(out.toString(), is("X"));
    }
}