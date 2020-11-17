package ru.job4j.lsp.foodstorage.storage;

import ru.job4j.lsp.foodstorage.model.Food;

import java.time.LocalDate;
import java.util.List;

public interface Storage {
    void addFood(Food food);

    boolean accept(Food food); // проверяет подходит ли еда под это хранилище. У каждого хранилища будет своя реализация

    List<Food> clear(); // Очищает хранилище и возвращает то, что в нем бы


    // Done
    // 2. В ControlQuality вы создаете список хранилищ
    // private final List<Storage> storages ...
    // 3. И метод distibute. В нем вы проходитесь по хранилищам.
    // Если метод accept возвращаем true, то добавляете продукт
    // в хранилище и выходите из цикла
}
