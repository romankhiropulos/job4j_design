package ru.job4j.lsp.foodstorage.model;

import java.time.LocalDate;

public class Meat extends Food {
    private static final double MEAT_DISCOUNT = 0.32;

    public Meat(String name, LocalDate createDate, LocalDate expireDate, double price) {
        super(name, createDate, expireDate, price);
        this.discount = MEAT_DISCOUNT;
    }
}
