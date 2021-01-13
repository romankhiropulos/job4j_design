package ru.job4j.tictactoe.input;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ConsoleInputTest {

    @Test
    public void askNumber() {
        String number = "3";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(number.getBytes()));
            Input consoleInput = new ConsoleInput(); // важно объявить после кода 19 строки
            int res = consoleInput.askNumber();
            assertThat(res, is(3));
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    public void example() {
        String data = "Hello, World!";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            Scanner scanner = new Scanner(System.in);
//            System.out.println(scanner.nextLine());
            assertThat(scanner.nextLine(), is(data));
        } finally {
            System.setIn(stdin);
        }
    }
}