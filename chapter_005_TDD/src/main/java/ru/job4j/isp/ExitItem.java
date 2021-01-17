package ru.job4j.isp;

/**
 * Class ExitItem
 * Класс реализует пункт меню, при выборе которого осуществляется выход из программы.
 */
public class ExitItem implements Item, ActionItem {
    /**
     * Наименование пункта меню.
     */
    private String name;

    /**
     * Конструктор инициализирует пункт меню.
     * @param name Наименование пункта меню.
     */
    public ExitItem(String name) {
        this.name = name;
    }

    /**
     * Метод возвращает наименование пункта меню.
     * @return Наименование пункта.
     */
    @Override
    public String name() {
        return name;
    }

    /**
     * Метод осуществляет выход из программы.
     * Для успешного выхода всегда должно возвращаться false.
     * @return false.
     */
    @Override
    public boolean execute() {
        return false;
    }
}
