package ru.job4j.isp;

/**
 * Class StubAction
 * Класс иммитирует некоторый пункт меню и выполнение некоторого действия при его выборе.
 */
public class StubAction implements Item, ActionItem {
    /**
     * Поле задает статус пункта меню.
     */
    private boolean call = false;

    /**
     * Метод возвращает наименование пункта меню.
     * @return Наименование пункта меню
     */
    @Override
    public String name() {
        return "Stub action";
    }

    /**
     * Метод меняет статус состояния меню при его выборе.
     * @return false
     */
    @Override
    public boolean execute() {
        call = true;
        return false;
    }

    /**
     * Метод возвращает статус выбора пункта меню.
     * Было ли выполнено действие при выборе пункта меню.
     * @return true, если действие было выполнено, иначе false
     */
    public boolean isCall() {
        return call;
    }
}
