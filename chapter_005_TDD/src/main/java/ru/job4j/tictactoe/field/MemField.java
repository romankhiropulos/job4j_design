package ru.job4j.tictactoe.field;

import ru.job4j.tictactoe.player.Player;
import ru.job4j.tictactoe.util.FieldUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemField implements Field {

    private final Player[] field;

    private int size;

    public MemField() {
        field = new Player[9];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String addChoice(Player player, int place) {
        String cont = "continue";
        String win = "win";
        field[place] = player;
        size++;
        return winCheck() ? win : cont;
    }

    @Override
    public boolean isFree(int place) {
        return field[place] == null;
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