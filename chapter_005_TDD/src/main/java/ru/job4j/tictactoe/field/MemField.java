package ru.job4j.tictactoe.field;

import ru.job4j.tictactoe.player.Player;

public class MemField implements Field {
    private final Player[][] FIELD;

    public MemField() {
        FIELD = new Player[3][3];
    }

    public Player[][] getFIELD() {
        return FIELD;
    }

    @Override
    public boolean addChoice(Player player, int place) {
        return false;
    }
}
