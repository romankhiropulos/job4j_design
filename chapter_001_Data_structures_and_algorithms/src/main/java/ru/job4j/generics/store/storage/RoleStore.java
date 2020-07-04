package ru.job4j.generics.store.storage;

import ru.job4j.generics.store.Store;
import ru.job4j.generics.store.exceptions.ExistStorageException;
import ru.job4j.generics.store.exceptions.NotExistStorageException;
import ru.job4j.generics.store.exceptions.StorageException;
import ru.job4j.generics.store.model.Role;

public class RoleStore implements Store<Role> {

    private final Store<Role> store = new MemStore<>();

    @Override
    public void add(Role model) {
        try {
            store.add(model);
        } catch (StorageException storageException) {
            throw new ExistStorageException("Role " + storageException.getId() + " already exist", storageException.getId());
        }
    }

    @Override
    public boolean replace(String id, Role model) {
        try {
            store.replace(id, model);
        } catch (StorageException storageException) {
            throw new NotExistStorageException("Role " + storageException.getId() + " not exist", storageException.getId());
        }
        return true;
    }

    @Override
    public boolean delete(String id) {
        try {
            store.delete(id);
        } catch (StorageException storageException) {
            throw new NotExistStorageException("Role " + storageException.getId() + " not exist", storageException.getId());
        }
        return true;
    }

    @Override
    public Role findById(String id) {
        Role searchUser;
        try {
            searchUser = store.findById(id);
        } catch (StorageException storageException) {
            throw new NotExistStorageException("Role " + storageException.getId() + " not exist", storageException.getId());
        }
        return searchUser;
    }
}
