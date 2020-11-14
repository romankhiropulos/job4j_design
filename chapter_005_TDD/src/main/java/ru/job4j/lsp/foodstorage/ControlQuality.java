package ru.job4j.lsp.foodstorage;

import ru.job4j.lsp.foodstorage.model.Food;
import ru.job4j.lsp.foodstorage.storage.Shop;
import ru.job4j.lsp.foodstorage.storage.Storage;
import ru.job4j.lsp.foodstorage.storage.Trash;
import ru.job4j.lsp.foodstorage.storage.Warehouse;

import java.time.LocalDate;
import java.time.Period;

public class ControlQuality {
    private Storage shop = new Shop();
    private Storage trash = new Trash();
    private Storage warehouse = new Warehouse();
    private final Storage[] storages = {shop, trash, warehouse};

    /**
     * restore() - Динамическое перераспределение продуктов
     */
    public void restore(Storage... storages) {
        for (Storage storage : storages) {
            reviseStorage(storage);
        }
    }

    public void reviseStorage(Storage foods) {
        Food currFood;
        LocalDate createdDate;
        LocalDate expire;
        int amountOfFoods = foods.getAllFoods().size();
        double resCheckExpire;
        for (int i = 0; i < amountOfFoods; i++) {
            currFood = foods.getAllFoods().get(i);
            createdDate = currFood.getCreateDate();
            expire = currFood.getExpireDate();
            resCheckExpire = checkProductExpire(createdDate, expire);
            foods.delete(i);
            if (resCheckExpire < 0.25) {
                warehouse.addFood(currFood);
            } else if (resCheckExpire >= 0.25 && resCheckExpire <= 0.75) {
                shop.addFood(currFood);
            } else if (resCheckExpire > 0.75 && resCheckExpire < 1) {
                currFood.changePriceByDiscount();
                shop.addFood(currFood);
            } else if (resCheckExpire >= 1) {
                trash.addFood(currFood);
            }
        }
    }

    private double checkProductExpire(LocalDate createdDate, LocalDate expire) {
        Period allPeriod = Period.between(createdDate, expire);
        Period partOfPeriod = Period.between(LocalDate.now(), expire);
        return ((double) partOfPeriod.getDays()) / (double) allPeriod.getDays();
    }
}
