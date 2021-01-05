package ru.job4j.tictactoe.input;

import ru.job4j.tictactoe.field.Field;

import java.util.Scanner;

public class InputValidation implements Input {
    private final Input input;

    private final Field field;

    // мб тертье поле для объекта аутпута
    public InputValidation(Input input, Field field) {
        this.input = input;
        this.field = field;
    }

//    @Override
//    public void printException(String message) {
//        input.printException(message);
//    }

    @Override
    public int askNumber() {
        int value;
        do {
            value = input.askNumber();
            if (value >= 0 && value < 9 && field.isFree(value)) {
                return value;
            } else if (value >= 0 && value < 9 && !field.isFree(value)) {
                throw new IllegalStateException("CellNotFree");
            } else {
                throw new NumberFormatException("NumberException");
            }

//                throw new NumberFormatException();
//            } catch (IllegalStateException ise) {
////                printException("Please select a key from 0 to 9 that you have not used yet.");
//                throw new IllegalStateException(ise.getMessage());
//            } catch (NumberFormatException nfe) {
////                printException("Please enter validate data again.");
//                throw new NumberFormatException("FormatException");
//            }
        } while (true);
    }
}
