package ru.job4j.tictactoe;

import ru.job4j.tictactoe.field.Field;
import ru.job4j.tictactoe.field.MemField;
import ru.job4j.tictactoe.input.ConsoleInput;
import ru.job4j.tictactoe.input.Input;
import ru.job4j.tictactoe.input.InputValidation;
import ru.job4j.tictactoe.player.Player;
import ru.job4j.tictactoe.rule.GameRule;
import ru.job4j.tictactoe.rule.Rule;

import java.util.List;

public class GameExecutor {
    public static void main(String[] args) {
        Field field = new MemField();
        Input inputType = new ConsoleInput();
        Input validation = new InputValidation(inputType, field);
        Rule gameRule = new GameRule(field);
        new GameExecutor().init(validation, field, gameRule);
    }

    public void init(Input input, Field field, Rule gameRule) {
        boolean run = true;
        while (run) {
            showField(field, input);
            showFreeCells(input);
            if (gameRule.isThereFreeCells()) {
                Player nextGamer = gameRule.nextPlayer();
                int cellNumber = input.askNumber(
                        "Gamer ".concat(nextGamer.getName())
                                .concat(", select a cell number: ")
                );
                String result = gameRule.nextMove(nextGamer, cellNumber);
                if ("win".equals(result)) {
                    run = false;
                    showField(field, input);
                    input.printException("Gamer \""
                            .concat(nextGamer.getName())
                            .concat("\" ")
                            .concat(result)
                            .concat("!")
                    );
                }
            } else {
                run = false;
                input.printException("Game Over!");
            }
        }
    }

    private void showField(Field field, Input input) {
        List<Player> players = field.getAllCells();
        int count = 0;
        StringBuilder line = new StringBuilder();
        line.append("\n");
        line.append("  ".concat("A ").concat("B ").concat("C\n"));
        for (Player player : players) {
            switch (count) {
                case (0):
                    line.append("1 ");
                    break;
                case (3):
                    line.append("\n2 ");
                    break;
                case (6):
                    line.append("\n3 ");
                    break;
                default:
                    break;
            }
            line.append(player.getName().equals("Dummy") ? "_" : player.getName()).append(" ");
            count++;
        }
        input.printException(line.toString());
    }

    private void showFreeCells(Input input) {
        StringBuilder line = new StringBuilder();
        line.append("\n");
        for (int i = 0; i < 9; i++) {
            switch (i) {
                case (0):
                    line.append(i).append(" - A").append(1).append("\n");
                    break;
                case (1):
                    line.append(i).append(" - B").append(1).append("\n");
                    break;
                case (2):
                    line.append(i).append(" - C").append(1).append("\n");
                    break;
                case (3):
                    line.append(i).append(" - A").append(2).append("\n");
                    break;
                case (4):
                    line.append(i).append(" - B").append(2).append("\n");
                    break;
                case (5):
                    line.append(i).append(" - C").append(2).append("\n");
                    break;
                case (6):
                    line.append(i).append(" - A").append(3).append("\n");
                    break;
                case (7):
                    line.append(i).append(" - B").append(3).append("\n");
                    break;
                case (8):
                    line.append(i).append(" - C").append(3).append("\n");
                    break;
                default:
                    break;
            }
        }
        input.printException(line.toString());
    }
}
