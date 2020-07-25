package ru.job4j.map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleHashMapTest {

    private SimpleHashMap<User, String> map;

    private static final String LAST_NAME_1 = "Balboa";
    private static final String LAST_NAME_2 = "Drago";
    private static final String LAST_NAME_3 = "Creed";
    private static final String LAST_NAME_4 = "Pennino";

    private static final String FIRST_NAME_1 = "Rockya";
    private static final String FIRST_NAME_2 = "Ivan";
    private static final String FIRST_NAME_3 = "Apollo";
    private static final String FIRST_NAME_4 = "Paulie";

    private static final User USER_1;
    private static final User USER_2;
    private static final User USER_3;
    private static final User USER_4;

    static {
        USER_1 = new User(FIRST_NAME_1, 0, new GregorianCalendar(1993, 12, 21));
        USER_2 = new User(FIRST_NAME_2, 3, new GregorianCalendar(1996, 11, 2));
        USER_3 = new User(FIRST_NAME_3, 2, new GregorianCalendar(1994, 1, 23));
        USER_4 = new User(FIRST_NAME_4, 5, new GregorianCalendar(1995, 2, 11));
    }

    @Before
    public void setUp() {
        map = new SimpleHashMap<>();
    }

    @Test
    public void whenInsertThenTrue() {
        map.insert(USER_1, LAST_NAME_1);
        map.insert(USER_2, LAST_NAME_2);
        assertTrue(map.insert(USER_3, FIRST_NAME_3));
    }

    @Test
    public void whenInsertAndChangeValueThenTrue() {
        map.insert(USER_1, LAST_NAME_1);
        map.insert(USER_2, LAST_NAME_2);
        assertTrue(map.insert(USER_2, "Chaykin"));
    }

    @Test
    public void whenMultiInsert() {
        map.insert(USER_1, LAST_NAME_1);
        map.insert(USER_2, LAST_NAME_2);
        map.insert(USER_3, LAST_NAME_3);
        map.insert(USER_4, LAST_NAME_4);
        assertThat(4, is(map.getSize()));
    }

    @Test
    public void whenMultiInsertAndThenResize() {
        User user;
        StringBuilder firstName = new StringBuilder("User");
        StringBuilder lastName = new StringBuilder("Name");
        Calendar date = new GregorianCalendar(1993, 2, 21);
        for (int i = 0; i < 180; i++) {
            firstName.append(i);
            lastName.append(i);
            user = new User(firstName.toString(), 3, date);
            map.insert(user, lastName.toString());
        }
        assertEquals(map.getCapacity(), 128);
        // assertEquals(map.getModCount(), 128);
    }

    @Test
    public void whenChangeValueThenGet() {
        map.insert(USER_1, LAST_NAME_1);
        map.insert(USER_2, LAST_NAME_2);
        assertTrue(map.insert(USER_2, "NameAfterChange"));
        assertEquals("NameAfterChange", map.get(USER_2));
    }

    @Test
    public void whenGet() {
        map.insert(USER_1, LAST_NAME_1);
        map.insert(USER_2, LAST_NAME_2);
        map.insert(USER_3, LAST_NAME_3);
        map.insert(USER_4, LAST_NAME_4);
        assertEquals(LAST_NAME_1, map.get(USER_1));
        assertEquals(LAST_NAME_2, map.get(USER_2));
        assertEquals(LAST_NAME_3, map.get(USER_3));
        assertEquals(LAST_NAME_4, map.get(USER_4));
    }

    @Test
    public void whenGetNull() {
        map.insert(null, LAST_NAME_1);
        assertEquals(LAST_NAME_1, map.get(null));
        map.insert(null, LAST_NAME_4);
        assertEquals(LAST_NAME_4, map.get(null));
    }

    @Test
    public void whenDeleteThanResult() {
        map.insert(null, LAST_NAME_1);
        assertEquals(LAST_NAME_1, map.get(null));
        map.insert(USER_4, LAST_NAME_4);
        map.insert(USER_2, LAST_NAME_2);
        map.insert(USER_3, LAST_NAME_3);
        assertTrue(map.delete(USER_4));
        assertFalse(map.delete(USER_1));
        assertFalse(map.delete(USER_4));
        assertTrue(map.delete(null));
        assertFalse(map.delete(null));
    }
}