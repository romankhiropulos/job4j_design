package ru.job4j.lsp.foodstorage.model;

import java.time.LocalDate;

public class Potato extends Food {
    private static final double POTATO_DISCOUNT = 0.4;

    public Potato(String name, LocalDate createDate, LocalDate expireDate, double price) {
        super(name, createDate, expireDate, price);
        this.discount = POTATO_DISCOUNT;
    }
}
