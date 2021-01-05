package ru.job4j.tictactoe.input;

import java.util.Scanner;

public class ConsoleInput implements Input {

    private final Scanner scanner = new Scanner(System.in);

//    private String askStr(String question) {
////        System.out.print(question);
//        return scanner.nextLine();
//    }

    @Override
    public int askNumber() {
        return Integer.parseInt(scanner.nextLine());
    }

//    @Override
//    public void printException(String message) {
//        System.out.println(message);
//    }
}
