package ru.job4j.isp;

import org.junit.Test;
import ru.job4j.isp.input.StubInput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class MenuTest
 *
 * @author
 * @version 1
 */
public class MenuTest {

    /**
     * Тест проверяет загрузку меню и выбор пункта меню пользователем.
     * А также иммитирует выполнение действия при выборе пункта меню.
     */
    @Test
    public void whenMenuAction() {
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action = new StubAction();
        new Menu().init(input, Arrays.asList(action));
        assertThat(action.isCall(), is(true));
    }

    /**
     * Тестируется вывод меню на консоль.
     */
    @Test
    public void whenPrtMenu() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action = new StubAction();
        new Menu().init(input, Arrays.asList(action));
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("0. Stub action")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}