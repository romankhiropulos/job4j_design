package ru.job4j.tictactoe;

import ru.job4j.tictactoe.field.Field;
import ru.job4j.tictactoe.field.MemField;
import ru.job4j.tictactoe.input.ConsoleInput;
import ru.job4j.tictactoe.input.Input;
import ru.job4j.tictactoe.input.InputValidation;
import ru.job4j.tictactoe.output.OutPut;
import ru.job4j.tictactoe.player.Player;
import ru.job4j.tictactoe.rule.GameRule;
import ru.job4j.tictactoe.rule.Rule;

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
        OutPut<OutputStream> outPut = getInstance(field);
        
        execute(input, gameRule, outPut);
    }
    
    private void execute(Input input, Rule gameRule, OutPut outPut) {
        boolean run = true;
        while (run) {
            outPut.printOutPut("Field");
            outPut.printOutPut("NumbersList");

            if (gameRule.isThereFreeCells()) {
                Player nextGamer = gameRule.nextPlayer();
                outPut.printOutPut(
                        nextGamer.getName().equals("X") ? MARK_X_KEY : MARK_0_KEY
                );

                int cellNumber;
                try {
                    cellNumber = input.askNumber();
                } catch (IllegalStateException | NumberFormatException exception) {
                    outPut.printOutPut(
                            exception instanceof IllegalStateException
                                   ? MARK_CELL_NOT_FREE_KEY : MARK_NUMBER_EXCEPTION_KEY
                    );
                    continue;
                }
                String result = gameRule.nextMove(nextGamer, cellNumber);
                if ("win".equals(result)) {
                    run = false;
                    outPut.printOutPut("Field");
                    outPut.printOutPut(nextGamer.getName().equals("X") ? "WinX" : "Win0");
                }
            } else {
                run = false;
                outPut.printOutPut("GameOver");
            }
        }
    }
}
