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

    Field field = new MemField();

    @Test
    public void print() {
        String message = fillString();
        Mark<OutputStream> mark = new ConsoleMarkField(field);
        var out = new ByteArrayOutputStream();
        mark.print(out);
        assertThat(out.toString(), is(message));
    }

    private String fillString() {
        List<Player> players = field.getAllCells();
        int count = 0;
        StringBuilder line = new StringBuilder();
        line.append("\n");
        line.append("  ".concat("A ").concat("B ").concat("C\n"));
        for (Player player : players) {
            switch (count) {
                case (0):
                    line.append("1 ");
                    break;
                case (3):
                    line.append("\n2 ");
                    break;
                case (6):
                    line.append("\n3 ");
                    break;
                default:
                    break;
            }
            line.append(player.getName().equals("Dummy") ? "_" : player.getName()).append(" ");
            count++;
        }
        return line.toString();
    }
}