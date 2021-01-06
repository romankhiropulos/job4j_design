package ru.job4j.tictactoe.input;

import java.util.Scanner;

public class ConsoleInput implements Input {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public int askNumber() {
        return Integer.parseInt(scanner.nextLine());
    }
}
