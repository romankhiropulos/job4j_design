package ru.job4j.isp;

import ru.job4j.isp.input.ConsoleInput;
import ru.job4j.isp.input.Input;
import ru.job4j.isp.task.ContainTask;
import ru.job4j.isp.task.PerformTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class Menu
 * Класс осуществляет вывод меню на консоль.
 */
public class Menu {
    /**
     * Коллекция хранит все пункты передаваемого меню, включая вложенные списки пунктов меню.
     */
    private List<Item> all = new ArrayList<>();
    /**
     * Вспомогательная коллекция, хранит строки для табуляции пунктов меню.
     */
    private List<String> tab = new ArrayList<>();
    /**
     * Поле определяет величину табуляции.
     */
    private String str = "";

    /**
     * Метод осуществляет инициализацию меню.
     * @param input Объект получает данные от пользователя.
     * @param items Список пунктов меню.
     */
    public void init(Input input, List<Item> items) {
        prepare(items);
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Выберите номер меню: ", all.size());
            Item item = all.get(select);
            if (item instanceof ActionItem) {
                run = ((ActionItem) item).execute();
            }
        }
    }

    /**
     * Метод осуществляет вывод меню на консоль.
     */
    private void showMenu() {
        for (int index = 0; index < all.size(); index++) {
            Item item = all.get(index);
            System.out.println(index + ". " + tab.get(index) + item.name());
        }
    }

    /**
     * Метод подготавливает меню для вывода на консоль.
     * Метод принимает список с пунктами меню и осуществляет извлечение вложенных пунктов.
     * Все пункты собираются в одну коллекцию. Симметричным образом формируется доп. коллекция,
     * в которую добавляется параметр табуляции пунктов меню, в соответствии с вложенностью пунктов.
     * @param items Список содержащий пункты меню.
     */
    private void prepare(List<Item> items) {
        for (Item item : items) {
            all.add(item);
            tab.add(str);

            if (item instanceof MultiItem) {
                str += "----";
                prepare(((MultiItem) item).get());
            }
        }
        str = !str.equals("") ? str.substring(4) : "";
    }

    /**
     * Главный метод программы. Формирует меню и выводит его на консоль.
     * @param args Параметры командной строки.
     */
    public static void main(String[] args) {
        ContainTask second = new ContainTask("Задача 1.1.");
        second.add(new PerformTask("Задача 1.1.1."));
        second.add(new PerformTask("Задача 1.1.2."));
        ContainTask first = new ContainTask("Задача 1.");
        first.add(second);
        first.add(new PerformTask("Задача 1.2."));
        List<Item> items = Arrays.asList(
                new ExitItem("Выход."),
                first,
                new PerformTask("Задача 2.")
        );
        new Menu().init(new ConsoleInput(), items);
    }
}
