package ru.job4j.lsp.foodstorage.storage;

import ru.job4j.lsp.foodstorage.StorageUtil;
import ru.job4j.lsp.foodstorage.model.Food;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {
    private List<Food> storage = new ArrayList<>();

    @Override
    public void addFood(Food food) {
        storage.add(food);
    }

    @Override
    public boolean accept(Food food) {
        boolean result = false;
        double expire = StorageUtil.checkProductExpire(food);
        if (expire >= 0.25 && expire <= 0.75) {
            result = true;
        } else if (expire > 0.75 && expire < 1) {
            food.changePriceByDiscount();
            result = true;
        }
        return result;
    }

    @Override
    public List<Food> clear() {
        List<Food> foods = new ArrayList<>(storage);
        storage.clear();
        return foods;
    }
}
