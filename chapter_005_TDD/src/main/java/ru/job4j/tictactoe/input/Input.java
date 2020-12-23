package ru.job4j.tictactoe.input;

/**
 * Interface Input
 * Интерфейс определяет работу класса по получению данных от пользователя.
 */
public interface Input {
    /**
     * Метод запрашивает от пользователя ввод данных от 0 до 9.
     *
     * @param question Вопрос на который нужно ответить пользователю
     * @return Число введенное пользователем
     */
    int askNumber(String question);

    /**
     * Метод выводит сообщение пользователю
     *
     * @param message Информационное сообщение пользователю
     */
    void printException(String message);
}