package ru.job4j.tictactoe.input;

import org.junit.Test;
import ru.job4j.tictactoe.field.Field;
import ru.job4j.tictactoe.field.MemField;
import ru.job4j.tictactoe.player.Gamer;
import ru.job4j.tictactoe.player.Player;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class InputValidationTest {

    private void imitateInput(String consoleStr) throws NumberFormatException, IllegalStateException {
        InputStream stdin = System.in;
        Field field;
        Input input;
        Input inputType;
        Player player;
        try {
            player = new Gamer("X");
            field = new MemField();
            field.addChoice(player, 5);
            System.setIn(new ByteArrayInputStream(consoleStr.getBytes()));
            inputType = new ConsoleInput();
            input = new InputValidation(inputType, field); // важно объявить после System.setIn
            int res = input.askNumber();
            assertThat(res, is(Integer.parseInt(consoleStr)));
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    public void whenNumberInDiapasonThenTrue() {
        imitateInput("3");
    }

    @Test(expected = NumberFormatException.class)
    public void whenNumberNotInDiapasonThenNFE() throws NumberFormatException {
        imitateInput("11");
    }

    @Test(expected = IllegalStateException.class)
    public void whenNumberInDiapasonButCellNotFreeThenISE() throws IllegalStateException {
        imitateInput("5");
    }
}