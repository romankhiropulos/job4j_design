package ru.job4j.tictactoe.mark;

public interface Mark<T> {
    void print();

    void print(T screen);
}
