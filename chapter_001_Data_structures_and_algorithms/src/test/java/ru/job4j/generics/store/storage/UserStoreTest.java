package ru.job4j.generics.store.storage;

public class UserStoreTest extends MemStoreTest {
    public UserStoreTest() {
        super(new UserStore());
    }
}