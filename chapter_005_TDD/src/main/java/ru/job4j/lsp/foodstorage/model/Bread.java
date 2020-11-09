package ru.job4j.lsp.foodstorage.model;

import java.time.LocalDate;

public class Bread extends Food {
    public Bread(String name, LocalDate createDate, LocalDate expireDate, double price) {
        super(name, createDate, expireDate, price);
    }
}
