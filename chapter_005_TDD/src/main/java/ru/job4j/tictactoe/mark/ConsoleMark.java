package ru.job4j.tictactoe.mark;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

public class ConsoleMark implements Mark<OutputStream> {

    private final String name;

    public ConsoleMark(String name) {
        Objects.requireNonNull(name, "name must not be null");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void print(OutputStream screen) {
        try {
            screen.write(name.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
