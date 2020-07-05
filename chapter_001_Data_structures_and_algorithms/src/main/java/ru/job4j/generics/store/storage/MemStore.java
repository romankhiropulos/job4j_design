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
        if (mem.contains(model)) {
            throw new StorageException(model.getId());
        }
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        mem.set(getSearchIndex(id), model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        mem.remove(getSearchIndex(id));
        return true;
    }

    @Override
    public T findById(String id) {
        try {
            return mem.get(getSearchIndex(id));
        } catch (StorageException exception) {
            return null;
        }
    }

    private int getSearchIndex(String id) {
        int searchIndex = -1;
        for (int i = 0; i < mem.size(); i++) {
            if (id.equals(mem.get(i).getId())) {
                searchIndex = i;
            }
        }
        if (!validate(searchIndex)) {
            throw new StorageException(id);
        }
        return searchIndex;
    }

    private boolean validate(Integer searchKey) {
        return searchKey >= 0;
    }
}
