package ru.job4j.lsp.foodstorage.storage;

import ru.job4j.lsp.foodstorage.model.Food;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AbstractStorage implements Storage {
    List<Food> storage = new ArrayList<>();

    @Override
    public void addFood(Food food) {
        storage.add(food);
    }

    @Override
    public boolean delete(int index) {
        return Objects.nonNull(storage.remove(index));
    }

    @Override
    public Food findByFood(Food food) {
        return null;
    }

    @Override
    public List<Food> getAllFoods() {
        return storage;
    }
}
