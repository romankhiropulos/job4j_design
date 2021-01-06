package ru.job4j.tictactoe.input;

import ru.job4j.tictactoe.field.Field;

public class InputValidation implements Input {
    private final Input input;

    private final Field field;

    public InputValidation(Input input, Field field) {
        this.input = input;
        this.field = field;
    }

    @Override
    public int askNumber() {
        int value;
        do {
            value = input.askNumber();
            if (value >= 0 && value < 9 && field.isFree(value)) {
                return value;
            } else if (value >= 0 && value < 9 && !field.isFree(value)) {
                throw new IllegalStateException("CellNotFree");
            } else if (value == 9) {
                return value;
            } else {
                throw new NumberFormatException("NumberException");
            }
        } while (true);
    }
}
