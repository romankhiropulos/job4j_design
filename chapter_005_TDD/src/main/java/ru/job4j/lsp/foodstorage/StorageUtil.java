package ru.job4j.lsp.foodstorage;

import ru.job4j.lsp.foodstorage.model.Food;

import java.time.LocalDate;
import java.time.Period;

public class StorageUtil {
    public static double checkProductExpire(Food food) {
        LocalDate createdDate = food.getCreateDate();
        LocalDate expire = food.getExpireDate();
        Period allPeriod = Period.between(createdDate, expire);
        Period partOfPeriod = Period.between(LocalDate.now(), expire);
        return ((double) partOfPeriod.getDays()) / (double) allPeriod.getDays();
    }
}
