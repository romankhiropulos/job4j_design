package ru.job4j.tictactoe.rule;

import ru.job4j.tictactoe.player.Player;

public interface Rule {
    Player nextPlayer();

    boolean isThereFreeCells();

    boolean isEmptyCell(int place);

    String nextMove(Player player, int place);
}
