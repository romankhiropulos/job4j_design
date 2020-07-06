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
        int searchIndex = getSearchIndex(id);
        if (!validate(searchIndex)) {
            return false;
        }
        mem.set(searchIndex, model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        int searchIndex = getSearchIndex(id);
        if (!validate(searchIndex)) {
            return false;
        }
        mem.remove(searchIndex);
        return true;
    }

    @Override
    public T findById(String id) {
        int searchIndex = getSearchIndex(id);
        if (!validate(searchIndex)) {
            return null;
        }
        return mem.get(searchIndex);
    }

    private int getSearchIndex(String id) {
        int searchIndex = -1;
        for (int i = 0; i < mem.size(); i++) {
            if (id.equals(mem.get(i).getId())) {
                searchIndex = i;
                break;
            }
        }
        return searchIndex;
    }

    private boolean validate(Integer searchKey) {
        return searchKey >= 0;
    }
}
