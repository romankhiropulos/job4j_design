package ru.job4j.lsp.foodstorage.storage;

import ru.job4j.lsp.foodstorage.model.Food;

import java.time.LocalDate;
import java.util.List;

public interface Storage {
    void addFood(Food food);

    boolean delete(int index);

    Food findByFood(Food food);

    List<Food> getAllFoods();
}
