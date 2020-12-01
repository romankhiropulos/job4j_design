package ru.job4j.tictactoe.rule;

import ru.job4j.tictactoe.player.Player;

public class Analysis implements Rule {

    private Player playerX;

    private Player playerO;

    private Player nextPlayer;

    public Analysis(Player playerX, Player playerO) {
        this.playerX = playerX;
        this.playerO = playerO;
    }

    @Override
    public Player nextPlayer() {
        if (nextPlayer == null) {
            nextPlayer = playerX;
        } else if (nextPlayer.equals(playerX)) {
            nextPlayer = playerO;
        } else if (nextPlayer.equals(playerO)) {
            nextPlayer = playerX;
        }
        return nextPlayer;
    }

    @Override
    public boolean analyseField(Player[][] players) {
        return false;
    }
}
