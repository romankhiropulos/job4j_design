package ru.job4j.tictactoe.output;

import org.junit.Test;
import ru.job4j.tictactoe.field.Field;
import ru.job4j.tictactoe.field.MemField;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConsoleOutPutTest {

    @Test
    public void whenOutPutGameOverThenTrue() {
        String message = OutPut.MARK_GAME_OVER;
        Field field = new MemField();
        OutPut<OutputStream> outPut = new ConsoleOutPut(field);
        var out = new ByteArrayOutputStream();
        outPut.printOutPut(OutPut.MARK_GAME_OVER_KEY, out);
        assertThat(out.toString(), is(message));
    }
}