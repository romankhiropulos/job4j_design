package ru.job4j.lsp.foodstorage.storage;

import ru.job4j.lsp.foodstorage.model.Food;

import java.time.LocalDate;
import java.util.List;

public interface Storage {
    void add(Food food);

    boolean delete(String name, LocalDate created);

    Food findByNameAndCreated(String name, LocalDate created);

    List<Food> getAllFoods();
}
