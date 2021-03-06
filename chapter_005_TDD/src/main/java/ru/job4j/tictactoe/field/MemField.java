package ru.job4j.tictactoe.field;

import ru.job4j.tictactoe.player.Gamer;
import ru.job4j.tictactoe.player.Player;
import ru.job4j.tictactoe.util.FieldUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemField implements Field {

    private final Player[] field;

    private int size;

    private static final String CONT = "continue";
    private static final String WIN = "win";

    public MemField() {
        field = new Player[9];
        for (int i = 0; i < 9; i++) {
            field[i] = new Gamer("Dummy");
        }
    }

    @Override
    public String addChoice(Player player, int place) {
        field[place] = player;
        size++;
        return winCheck() ? WIN : CONT;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isFree(int place) {
        return field[place].getName().equals("Dummy");
    }

    @Override
    public List<Player> getAllCells() {
        return new ArrayList<>(Arrays.asList(field));
    }

    private boolean winCheck() {
        for (int[] item : FieldUtils.getWinArrays()) {
            if (field[item[0]] == field[item[1]]
                    && field[item[0]] == field[item[2]]
                    && field[item[1]] == field[item[2]]) {
                return true;
            }
        }
        return false;
    }
}