package ru.job4j.tictactoe.output;

import ru.job4j.tictactoe.field.Field;
import ru.job4j.tictactoe.mark.ConsoleMark;
import ru.job4j.tictactoe.mark.ConsoleMarkField;
import ru.job4j.tictactoe.mark.ConsoleMarkNumbersList;
import ru.job4j.tictactoe.mark.Mark;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class ConsoleOutPut implements OutPut<OutputStream> {
    private final Map<String, Mark<OutputStream>> marks = new HashMap<>(); // ? enumMap

    private static final String MARK_X = "Gamer ".concat("X")
                                                 .concat(", select a cell number: ");
    private static final String MARK_0 = "Gamer ".concat("0")
                                                 .concat(", select a cell number: ");
    private static final String MARK_WIN_X = "Player \"X\" Win!";
    private static final String MARK_WIN_0 = "Player \"0\" Win!";
    private static final String MARK_GAME_OVER = "Game Over!";
    private static final String MARK_CELL_NOT_FREE = "Please select a key from 0 to 9 that you have not used yet.";
    private static final String MARK_NUMBER_EXCEPTION = "Please enter validate data again.";

    public ConsoleOutPut(Field field) {
        Mark<OutputStream> fieldMark = new ConsoleMarkField(field);
        Mark<OutputStream> numbersMark = new ConsoleMarkNumbersList();
        Mark<OutputStream> markX = new ConsoleMark(MARK_X);
        Mark<OutputStream> mark0 = new ConsoleMark(MARK_0);
        Mark<OutputStream> markWinX = new ConsoleMark(MARK_WIN_X);
        Mark<OutputStream> markWin0 = new ConsoleMark(MARK_WIN_0);
        Mark<OutputStream> markGameOver = new ConsoleMark(MARK_GAME_OVER);
        Mark<OutputStream> markCellNotFree = new ConsoleMark(MARK_CELL_NOT_FREE);
        Mark<OutputStream> markNumberException = new ConsoleMark(MARK_NUMBER_EXCEPTION);

        marks.put(MARK_FIELD_KEY, fieldMark);
        marks.put(MARK_NUMBERS_KEY, numbersMark);
        marks.put(MARK_X_KEY, markX);
        marks.put(MARK_0_KEY, mark0);
        marks.put(MARK_WIN_X_KEY, markWinX);
        marks.put(MARK_WIN_0_KEY, markWin0);
        marks.put(MARK_GAME_OVER_KEY, markGameOver);
        marks.put(MARK_CELL_NOT_FREE_KEY, markCellNotFree);
        marks.put(MARK_NUMBER_EXCEPTION_KEY, markNumberException);
    }

    @Override
    public void printOutPut(String mark) {
        marks.get(mark).print();
    }

    @Override
    public void printOutPut(String mark, OutputStream screen) {

    }
}
