package ru.job4j.tictactoe;

import ru.job4j.tictactoe.field.Field;
import ru.job4j.tictactoe.field.MemField;
import ru.job4j.tictactoe.input.ConsoleInput;
import ru.job4j.tictactoe.input.Input;
import ru.job4j.tictactoe.input.InputValidation;
import ru.job4j.tictactoe.output.ConsoleOutPut;
import ru.job4j.tictactoe.output.OutPut;
import ru.job4j.tictactoe.player.Player;
import ru.job4j.tictactoe.rule.GameRule;
import ru.job4j.tictactoe.rule.Rule;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import static ru.job4j.tictactoe.output.ConsoleOutPut.*;

public class GameExecutor {
    
    public static void main(String[] args) {
        new GameExecutor().runApp();
    }
    
    public void runApp() {

        Field field = new MemField();
        Input inputType = new ConsoleInput();
        Input input = new InputValidation(inputType, field);
        Rule gameRule = new GameRule(field);
        OutPut<OutputStream> outPut = new ConsoleOutPut(field);
        
        execute(input, gameRule, outPut);
    }
    
    private void execute(Input input, Rule gameRule, OutPut outPut) {
        boolean run = true;
        boolean trueNumber = true;
        Player nextGamer = null;
        int cellNumber;
        while (run) {
            outPut.printOutPut(MARK_FIELD_KEY, new ByteArrayOutputStream());
            outPut.printOutPut(MARK_NUMBERS_KEY, new ByteArrayOutputStream());
            if (gameRule.isThereFreeCells()) {
                nextGamer = trueNumber ? gameRule.nextPlayer() : nextGamer;
                outPut.printOutPut(
                        nextGamer.getName().equals("X") ? MARK_X_KEY : MARK_0_KEY,
                        new ByteArrayOutputStream());

                try {
                    cellNumber = input.askNumber();
                    trueNumber = true;
                } catch (IllegalStateException | NumberFormatException exception) {
                    outPut.printOutPut(
                            exception instanceof IllegalStateException
                                   ? MARK_CELL_NOT_FREE_KEY : MARK_NUMBER_EXCEPTION_KEY,
                                new ByteArrayOutputStream());
                    trueNumber = false;
                    continue;
                }
                if (cellNumber == 9) {
                    outPut.printOutPut(MARK_GAME_OVER_KEY, new ByteArrayOutputStream());
                    break;
                }

                String result = gameRule.nextMove(nextGamer, cellNumber);
                if ("win".equals(result)) {
                    run = false;
                    outPut.printOutPut(MARK_FIELD_KEY, new ByteArrayOutputStream());
                    outPut.printOutPut(nextGamer.getName().equals("X") ? MARK_WIN_X_KEY : MARK_WIN_0_KEY,
                            new ByteArrayOutputStream());
                }
            } else {
                run = false;
                outPut.printOutPut(MARK_GAME_OVER_KEY, new ByteArrayOutputStream());
            }
        }
    }
}
