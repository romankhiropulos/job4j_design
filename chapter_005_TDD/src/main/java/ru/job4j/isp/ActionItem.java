package ru.job4j.isp;

/**
 * Interface ActionItem
 * Интерфейс определяет метод, который необходимо выполнить при выборе пункта меню.
 */
public interface ActionItem {
    /**
     * Метод выполняет заданное действие при выборе пункта меню.
     * @return true, если действие выполнено успешно, иначе о false.
     */
    boolean execute();
}
