package ru.job4j.lsp.foodstorage.model;

import java.time.LocalDate;

public class Milk extends Food {
    private static final double MILK_DISCOUNT = 0.3;

    public Milk(String name, LocalDate createDate, LocalDate expireDate, double price) {
        super(name, createDate, expireDate, price);
        this.discount = MILK_DISCOUNT;
    }
}
