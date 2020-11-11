package ru.job4j.lsp.foodstorage;

import ru.job4j.lsp.foodstorage.model.Food;
import ru.job4j.lsp.foodstorage.storage.Shop;
import ru.job4j.lsp.foodstorage.storage.Storage;
import ru.job4j.lsp.foodstorage.storage.Trash;
import ru.job4j.lsp.foodstorage.storage.Warehouse;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class ControlQuality {
    Storage shop = new Shop();
    Storage trash = new Trash();
    Storage warehouse = new Warehouse();

    void redistributeProducts(Storage...storages) {
        List<Food> foods;
        for (Storage storage : storages) {
            foods = storage.getAllFoods();
            reviseStorage(foods);
        }
    }

    void reviseStorage(List<Food> foods) {
//            3.1. Если срок годности израсходован меньше чем на 25% направить в Warehouse.
//
//            3.2 Если срок годности от 25% до 75% направить в Shop
//
//            3.3. Если срок годности больше 75% то выставить скидку на продукт и отправить в Shop
//
//            3.4. Если срок годности вышел. Отправить продукт в мусорку.
        Food currFood;
        LocalDate createdDate;
        LocalDate expire;
        int amountOfFoods = foods.size();
        for (int i = 0; i < amountOfFoods; i++) {
            currFood = foods.get(i);
            createdDate = currFood.getCreateDate();
            expire = currFood.getExpireDate();
            if (checkShelfLife(createdDate, expire) > 0.25) {
                System.out.println();
            }
        }
    }

    private double checkShelfLife(LocalDate createdDate, LocalDate expire) {
        Period allPeriod = Period.between(createdDate, expire);
        Period partOfPeriod = Period.between(LocalDate.now(), expire);
        return ((double) partOfPeriod.getDays()) / (double) allPeriod.getDays();
    }
}
