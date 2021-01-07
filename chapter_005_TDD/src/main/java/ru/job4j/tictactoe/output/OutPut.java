package ru.job4j.tictactoe.output;

public interface OutPut<T> {
    String MARK_FIELD_KEY = "Field";
    String MARK_NUMBERS_KEY = "NumbersList";
    String MARK_X_KEY = "X";
    String MARK_0_KEY = "0";
    String MARK_WIN_X_KEY = "WinX";
    String MARK_WIN_0_KEY = "Win0";
    String MARK_GAME_OVER_KEY = "GameOver";
    String MARK_CELL_NOT_FREE_KEY = "CellNotFree";
    String MARK_NUMBER_EXCEPTION_KEY = "NumberException";

    String MARK_X = "Gamer ".concat("X")
            .concat(", select a cell number: ");
    String MARK_0 = "Gamer ".concat("0")
            .concat(", select a cell number: ");
    String MARK_WIN_X = "Player \"X\" Win!";
    String MARK_WIN_0 = "Player \"0\" Win!";
    String MARK_GAME_OVER = "Game Over!";
    String MARK_CELL_NOT_FREE = "Please select a key from 0 to 9 that you have not used yet.";
    String MARK_NUMBER_EXCEPTION = "Please enter validate data again.";

    void printOutPut(String mark);

    void printOutPut(String mark, T screen);
}
