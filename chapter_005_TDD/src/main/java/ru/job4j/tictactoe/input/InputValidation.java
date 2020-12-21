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
    public void print(String message) {
        input.print(message);
    }

    @Override
    public int askNumber(String question) {
        int value;
        do {
            try {
                value = input.askNumber(question);
                if (value >= 0 && value < 9 && field.isFree(value)) {
                    return value;
                } else {
                    throw new IllegalStateException(String
                            .format("Out of about %s > [0, %s]", value, 8));
                }
            } catch (IllegalStateException ise) {
                print("Please select key from list.");
            } catch (NumberFormatException nfe) {
                print("Please enter validate data again.");
            }
        } while (true);
    }
}
