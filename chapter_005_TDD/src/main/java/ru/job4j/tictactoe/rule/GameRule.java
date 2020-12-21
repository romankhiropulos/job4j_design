package ru.job4j.tictactoe.rule;

import ru.job4j.tictactoe.field.Field;
import ru.job4j.tictactoe.input.Input;
import ru.job4j.tictactoe.player.Gamer;
import ru.job4j.tictactoe.player.Player;

public class GameRule implements Rule {

    private final Field field;

    private final Player playerX;

    private final Player player0;

    private Player nextPlayer;

    public GameRule(Field field) {
        this.field = field;
        playerX = new Gamer("X");
        player0 = new Gamer("0");
    }

    @Override
    public boolean isEmptyCell(int place) {
        return field.getAllCells().get(place) == null;
    }

    @Override
    public boolean isThereFreeCells() {
        return field.getSize() < 9;
    }

    @Override
    public Player nextPlayer() {
        if (nextPlayer == null) {
            nextPlayer = playerX;
        } else if (nextPlayer.equals(playerX)) {
            nextPlayer = player0;
        } else if (nextPlayer.equals(player0)) {
            nextPlayer = playerX;
        }

        return nextPlayer;
    }

    @Override
    public String nextMove(Player player, int place) {
        return field.addChoice(player, place);
    }
}
