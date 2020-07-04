package ru.job4j.generics.store.storage;

import ru.job4j.generics.store.Store;
import ru.job4j.generics.store.exceptions.StorageException;
import ru.job4j.generics.store.model.Base;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        if (!mem.contains(model)) {
            mem.add(model);
        } else {
            throw new StorageException(model.getId());
        }
    }

    @Override
    public boolean replace(String id, T model) {
        T searchKey = findById(id);
        mem.set(mem.indexOf(searchKey), model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        T searchKey;
        searchKey = findById(id);
        return mem.remove(searchKey);
    }

    @Override
    public T findById(String id) {
        int searchIndex = getSearchIndex(id);
        if (!validate(searchIndex)) {
            throw new StorageException(id);
        }
        return mem.get(searchIndex);
    }

    private Integer getSearchIndex(String uuid) {
        for (int i = 0; i < mem.size(); i++) {
            if (uuid.equals(mem.get(i).getId())) {
                return i;
            }
        }
        return -1;
    }

    private boolean validate(Integer searchKey) {
        return searchKey >= 0;
    }
}
