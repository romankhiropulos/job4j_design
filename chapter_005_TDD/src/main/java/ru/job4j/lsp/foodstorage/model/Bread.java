package ru.job4j.lsp.foodstorage.model;

import java.time.LocalDate;

public class Bread extends Food {
    private static final double BRED_DISCOUNT = 0.25;

    public Bread(String name, LocalDate createDate, LocalDate expireDate, double price) {
        super(name, createDate, expireDate, price);
        this.discount = BRED_DISCOUNT;
    }
}
