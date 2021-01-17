package ru.job4j.isp;

import java.util.List;

/**
 * Interface MultiItem
 * Интерфейс определяет вложенный пункт меню.
 */
public interface MultiItem {
    /**
     * Метод возвращает список пунктов меню.
     * @return Список пунктов меню.
     */
    List<Item> get();

    /**
     * Метод добавляет пункт в список.
     * @param item Пункт меню.
     */
    void add(Item item);
}
