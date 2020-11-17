package ru.job4j.lsp.foodstorage.storage;

import ru.job4j.lsp.foodstorage.StorageUtil;
import ru.job4j.lsp.foodstorage.model.Food;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {
    private List<Food> storage = new ArrayList<>();

    @Override
    public void addFood(Food food) {
        storage.add(food);
    }

    @Override
    public boolean accept(Food food) {
        return StorageUtil.checkProductExpire(food) >= 1;
    }

    @Override
    public List<Food> clear() {
        List<Food> foods = new ArrayList<>(storage);
        storage.clear();
        return foods;
    }
}
