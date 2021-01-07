package ru.job4j.tictactoe.rule;

import org.junit.Test;
import ru.job4j.tictactoe.field.Field;
import ru.job4j.tictactoe.field.MemField;
import ru.job4j.tictactoe.player.Gamer;
import ru.job4j.tictactoe.player.Player;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class GameRuleTest {

    @Test
    public void whenIsThereFreeCellsThenTrue() {
        Field field = new MemField();
        Rule rule = new GameRule(field);
        Player player = new Gamer("X");
        field.addChoice(player, 0);
        assertThat(rule.isThereFreeCells(), is(true));
    }

    @Test
    public void whenNextPlayerXThanTrue() {
        Field field = new MemField();
        Rule rule = new GameRule(field);
        Player player0 = new Gamer("0");
        rule.nextPlayer();
        assertThat(rule.nextPlayer(), is(player0));
    }

    @Test
    public void whenNextMoveThanTrue() {
        Field field = new MemField();
        Rule rule = new GameRule(field);
        Player player = new Gamer("X");
        field.addChoice(player, 0);
        assertThat(rule.nextMove(player, 2), is("continue"));
    }
}