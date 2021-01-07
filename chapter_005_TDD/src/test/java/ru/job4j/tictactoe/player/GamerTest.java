package ru.job4j.tictactoe.player;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class GamerTest {

    @Test
    public void whenGetNameXThenTrue() {
        Player player = new Gamer("X");
        assertThat(player.getName(), is("X"));
    }
}