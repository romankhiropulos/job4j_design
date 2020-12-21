package ru.job4j.tictactoe.field;

import ru.job4j.tictactoe.mark.Mark;
import ru.job4j.tictactoe.player.Player;

import java.util.List;

public interface Field {
    String addChoice(Player player, int place);

    boolean isFree(int place);

    List<Player> getAllCells();

    int getSize();
}
