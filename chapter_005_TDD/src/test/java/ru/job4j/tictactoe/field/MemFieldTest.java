package ru.job4j.tictactoe.field;

import org.junit.Test;
import ru.job4j.tictactoe.player.Gamer;
import ru.job4j.tictactoe.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MemFieldTest {

    @Test
    public void whenAddChoiceThenReturnWin() {
        Field field = new MemField();
        Player player = new Gamer("X");
        field.addChoice(player, 0);
        field.addChoice(player, 1);
        assertThat(field.addChoice(player, 2), is("win"));
    }

    @Test
    public void whenAddChoiceThenReturnContinue() {
        Field field = new MemField();
        Player player = new Gamer("X");
        field.addChoice(player, 0);
        assertThat(field.addChoice(player, 2), is("continue"));
    }

    @Test
    public void whenAddPlayerThenSize1() {
        Field field = new MemField();
        Player player = new Gamer("X");
        field.addChoice(player, 0);
        assertThat(field.getSize(), is(1));
    }

    @Test
    public void whenCellIsInitialThenTrue() {
        Field field = new MemField();
        assertThat(field.isFree(5), is(true));
    }

    @Test
    public void whenGetAllCellsEqualsExpectedListThanTrue() {
        Field field = new MemField();
        Player player = new Gamer("X");
        field.addChoice(player, 0);
        field.addChoice(player, 1);

        Player[] arrField = new Player[9];
        for (int i = 0; i < 9; i++) {
            arrField[i] = new Gamer("Dummy");
        }
        arrField[0] = player;
        arrField[1] = player;
        List<Player> list = new ArrayList<>(Arrays.asList(arrField));

        assertEquals(list, field.getAllCells());
    }
}