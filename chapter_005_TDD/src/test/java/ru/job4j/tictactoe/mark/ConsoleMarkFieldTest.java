package ru.job4j.tictactoe.mark;

import org.junit.Test;
import ru.job4j.tictactoe.field.Field;
import ru.job4j.tictactoe.field.MemField;
import ru.job4j.tictactoe.player.Player;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ConsoleMarkFieldTest {

    @Test
    public void print() {
        Field field = new MemField();
        ConsoleMarkField mark = new ConsoleMarkField(field);
        String message = mark.getMessage();
        var out = new ByteArrayOutputStream();
        mark.print(out);
        assertThat(out.toString(), is(message));
    }
}