package ru.job4j.lsp.foodstorage;

import ru.job4j.lsp.foodstorage.model.Food;
import ru.job4j.lsp.foodstorage.storage.Shop;
import ru.job4j.lsp.foodstorage.storage.Storage;
import ru.job4j.lsp.foodstorage.storage.Trash;
import ru.job4j.lsp.foodstorage.storage.Warehouse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ControlQuality {
    private Storage shop = new Shop();
    private Storage trash = new Trash();
    private Storage warehouse = new Warehouse();
    private final List<Storage> storages = Arrays.asList(shop, trash, warehouse);

    /**
     * restore() - Динамическое перераспределение продуктов
     */
    public void restore(List<Storage> storages) {
        List<Food> foods = new ArrayList<>();
        for (Storage storage : storages) {
            foods.addAll(storage.clear());
        }
        redistributeFoods(foods);
    }

    public void redistributeFoods(List<Food> foods) {
        foods.forEach(food -> storages.forEach(storage -> {
            if (storage.accept(food)) {
                storage.addFood(food);
            }
        }));
    }
}
