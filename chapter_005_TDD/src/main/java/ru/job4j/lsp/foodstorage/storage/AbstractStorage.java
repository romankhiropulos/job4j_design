package ru.job4j.lsp.foodstorage.storage;

import ru.job4j.lsp.foodstorage.model.Food;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AbstractStorage implements Storage {
    List<Food> storage = new ArrayList<>();

    @Override
    public void add(Food food) {

    }

    @Override
    public boolean delete(String name, LocalDate created) {
        return false;
    }

    @Override
    public Food findByNameAndCreated(String name, LocalDate created) {
        return null;
    }

    @Override
    public List<Food> getAllFoods() {
        return storage;
    }
}
