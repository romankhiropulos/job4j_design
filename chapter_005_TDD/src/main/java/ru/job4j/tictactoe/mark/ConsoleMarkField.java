package ru.job4j.tictactoe.mark;

import ru.job4j.tictactoe.field.Field;
import ru.job4j.tictactoe.player.Player;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class ConsoleMarkField implements Mark<OutputStream> {

    private final Field field;

    public ConsoleMarkField(Field field) {
        this.field = field;
    }

    @Override
    public void print() {
        System.out.println(fillString());
    }

    @Override
    public void print(OutputStream screen) {
        try {
            screen.write(fillString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
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
