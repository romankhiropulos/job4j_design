package ru.job4j.lsp.foodstorage.model;

import java.time.LocalDate;

public class Meat extends Food {
    public Meat(String name, LocalDate createDate, LocalDate expireDate, double price) {
        super(name, createDate, expireDate, price);
    }
}
