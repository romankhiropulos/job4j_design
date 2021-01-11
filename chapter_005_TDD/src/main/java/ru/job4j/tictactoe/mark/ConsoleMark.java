package ru.job4j.tictactoe.mark;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

public class ConsoleMark implements Mark<OutputStream> {

    private String message;

    public ConsoleMark(String message) {
        Objects.requireNonNull(message, "message must not be null");
        this.message = message;
    }

    @Override
    public final void print(OutputStream screen) {
        try {
            screen.write(getMessage().getBytes());
            System.out.println(screen);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
