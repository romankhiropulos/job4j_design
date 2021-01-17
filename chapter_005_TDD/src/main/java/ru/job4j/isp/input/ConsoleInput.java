package ru.job4j.isp.input;

import java.util.Scanner;

/**
 * Class ConsoleInput
 * Класс осуществляет взаимодействие с пользователем через консоль.
 */
public class ConsoleInput implements Input {
    /**
     * Поле создает и инициализирует объект Scanner.
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Метод задает пользователю вопрос и возвращает введенный пользователем ответ в виде строки.
     * @param question Вопрос на который нужно ответить пользователю
     * @return Строка введенная пользователем
     */
    @Override
    public String askStr(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    /**
     * Метод задает пользователю вопрос и возвращает введенный пользователем ответ в виде числа.
     * @param question Вопрос на который нужно ответить пользователю
     * @return Число введенное пользователем
     */
    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }

    /**
     * Метод запрашивает от пользователя ввод данных от 0 до max.
     * @param question Вопрос на который нужно ответить пользователю
     * @param max Максимальное число, которое может ввести пользователь
     * @return Число введенное пользователем
     */
    @Override
    public int askInt(String question, int max) {
        int select = askInt(question);
        if (select < 0 || select >= max) {
            throw new IllegalStateException(
                    String.format("Out of about %s > [0, %s]", select, max));
        }
        return select;
    }
}
