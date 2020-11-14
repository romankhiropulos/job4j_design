package ru.job4j.lsp.foodstorage.model;

import java.time.LocalDate;

public class Chocolate extends Food {
    private static final double CHOCOLATE_DISCOUNT = 0.15;

    public Chocolate(String name, LocalDate createDate, LocalDate expireDate, double price) {
        super(name, createDate, expireDate, price);
        this.discount = CHOCOLATE_DISCOUNT;
    }
}
