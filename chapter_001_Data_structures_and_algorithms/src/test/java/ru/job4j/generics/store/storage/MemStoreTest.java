package ru.job4j.generics.store.storage;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.job4j.generics.store.Store;
import ru.job4j.generics.store.exceptions.ExistStorageException;
import ru.job4j.generics.store.exceptions.NotExistStorageException;
import ru.job4j.generics.store.exceptions.StorageException;
import ru.job4j.generics.store.model.Base;
import ru.job4j.generics.store.model.User;

import java.util.UUID;

import static org.junit.Assert.*;

public abstract class MemStoreTest {

    private Store storage;

    private static final String ID_1 = "111";
    private static final String ID_2 = "222";
    private static final String ID_3 = "333";
    private static final String ID_4 = "444";

    private static final String LAST_NAME_1 = "Balboa";
    private static final String LAST_NAME_2 = "Drago";
    private static final String LAST_NAME_3 = "Creed";
    private static final String LAST_NAME_4 = "Pennino";

    private static final String FIRST_NAME_1 = "Rockya";
    private static final String FIRST_NAME_2 = "Ivan";
    private static final String FIRST_NAME_3 = "Apollo";
    private static final String FIRST_NAME_4 = "Paulie";

    private static final User USER_1 = new User(ID_1, FIRST_NAME_1, LAST_NAME_1, 70);
    private static final User USER_2 = new User(ID_2, FIRST_NAME_2, LAST_NAME_2, 60);
    private static final User USER_3 = new User(ID_3, FIRST_NAME_3, LAST_NAME_3, 74);
    private static final User USER_4 = new User(ID_4, FIRST_NAME_4, LAST_NAME_4, 75);

    public MemStoreTest(Store storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.add(USER_1);
        storage.add(USER_2);
        storage.add(USER_3);
    }

    @Test(expected = StorageException.class)
    public void whenAdd() {
        storage.add(USER_4);
        assertEquals(USER_4, storage.findById(USER_4.getId()));
        storage.add(USER_1);
    }

    @Test
    public void whenReplaceThenCheck() {
        assertTrue(storage.replace("333", USER_4));
        assertEquals(USER_4, storage.findById("444"));
        assertFalse(storage.replace("333", USER_4));
    }

    @Test
    public void whenDeleteOneThenNull() {
        storage.delete("111");
        assertNull(storage.findById("111"));
    }

    @Test
    public void whenFindByIdThenCheckThis() {
        assertNull(storage.findById("555"));
        storage.findById("");
        assertEquals(USER_1, storage.findById("111"));
    }
}