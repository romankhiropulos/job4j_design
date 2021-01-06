package ru.job4j.tictactoe.rule;

import ru.job4j.tictactoe.player.Player;

public interface Rule {
    Player nextPlayer();

    boolean isThereFreeCells();

    String nextMove(Player player, int place);
}
