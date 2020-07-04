package ru.job4j.generics.store.storage;

import ru.job4j.generics.store.Store;
import ru.job4j.generics.store.exceptions.ExistStorageException;
import ru.job4j.generics.store.exceptions.NotExistStorageException;
import ru.job4j.generics.store.exceptions.StorageException;
import ru.job4j.generics.store.model.User;

public class UserStore implements Store<User> {

    private final Store<User> store = new MemStore<>();

    @Override
    public void add(User model) {
        try {
            store.add(model);
        } catch (StorageException storageException) {
            throw new ExistStorageException("User " + storageException.getId() + " already exist", storageException.getId());
        }
    }

    @Override
    public boolean replace(String id, User model) {
        try {
            store.replace(id, model);
        } catch (StorageException storageException) {
            throw new NotExistStorageException("User " + storageException.getId() + " not exist", storageException.getId());
        }
        return true;
    }

    @Override
    public boolean delete(String id) {
        try {
            store.delete(id);
        } catch (StorageException storageException) {
            throw new NotExistStorageException("User " + storageException.getId() + " not exist", storageException.getId());
        }
        return true;
    }

    @Override
    public User findById(String id) {
        User searchUser;
        try {
            searchUser = store.findById(id);
        } catch (StorageException storageException) {
            throw new NotExistStorageException("User " + storageException.getId() + " not exist", storageException.getId());
        }
        return searchUser;
    }
}
