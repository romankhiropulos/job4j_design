package ru.job4j.tictactoe;

import org.junit.Test;
import ru.job4j.tictactoe.mark.ConsoleMarkO;

import java.io.ByteArrayOutputStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ConsoleMarkOTest {

    @Test
    public void print() {
        var out = new ByteArrayOutputStream();
        new ConsoleMarkO().print(out);
        assertThat(out.toString(), is("O"));
    }
}