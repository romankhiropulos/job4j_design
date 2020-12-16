package ru.job4j.tictactoe.field;

import ru.job4j.tictactoe.mark.Mark;
import ru.job4j.tictactoe.player.Player;

public interface Field {
    boolean addChoice(Player player, int place);

    boolean analyze(int place);
}
