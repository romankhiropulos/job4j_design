package ru.job4j.lsp.foodstorage.model;

import java.time.LocalDate;

public class Milk extends Food {
    public Milk(String name, LocalDate createDate, LocalDate expireDate, double price) {
        super(name, createDate, expireDate, price);
    }
}
