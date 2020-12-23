package ru.job4j.tictactoe.input;

import java.util.Scanner;

public class ConsoleInput implements Input {

    private final Scanner scanner = new Scanner(System.in);

    private String askStr(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    @Override
    public int askNumber(String question) {
        return Integer.parseInt(askStr(question));
    }

    @Override
    public void printException(String message) {
        System.out.println(message);
    }
}
