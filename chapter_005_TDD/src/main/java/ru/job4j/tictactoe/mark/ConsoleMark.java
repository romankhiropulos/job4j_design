package ru.job4j.tictactoe.mark;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

public class ConsoleMark implements Mark<OutputStream> {

    private final String message;

    public ConsoleMark(String message) {
        Objects.requireNonNull(message, "message must not be null");
        this.message = message;
    }

    @Override
    public void print() {
        System.out.println(message);
    }

    @Override
    public void print(OutputStream screen) {
        try {
            screen.write(message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
