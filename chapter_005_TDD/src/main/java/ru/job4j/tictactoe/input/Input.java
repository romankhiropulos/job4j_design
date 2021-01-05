package ru.job4j.tictactoe.input;

/**
 * Interface Input
 * Интерфейс определяет работу класса по получению данных от пользователя.
 */
public interface Input {
    /**
     * Метод запрашивает от пользователя ввод данных от 0 до 9.
     *
     * @return Число введенное пользователем
     */
    int askNumber();

//    /**
//     * Метод выводит сообщение пользователю
//     *
//     * @param message Информационное сообщение пользователю
//     */
//    void printException(String message);
}