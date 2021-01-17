package ru.job4j.isp.task;

import ru.job4j.isp.ActionItem;
import ru.job4j.isp.Item;

/**
 * Class PerformTask
 * Класс описывает пункт меню, при выборе которого будет выполнено заданное действие.
 */
public class PerformTask implements Item, ActionItem {
    /**
     * Наименование пункта меню.
     */
    private String name;

    /**
     * Конструктор инициализирует пункт меню.
     * @param name Наименование пункта меню.
     */
    public PerformTask(String name) {
        this.name = name;
    }

    /**
     * Метод возвращает наименование пункта меню.
     * @return Наименование пункта меню.
     */
    @Override
    public String name() {
        return name;
    }

    /**
     * Метод выполняет заданное действие при выборе данного пункта меню.
     * @return true, если действие выполнено успешно, иначе false.
     */
    @Override
    public boolean execute() {
        System.out.println("-------------------");
        System.out.println("Выполнена " + name);
        System.out.println("-------------------");
        return true;
    }
}
