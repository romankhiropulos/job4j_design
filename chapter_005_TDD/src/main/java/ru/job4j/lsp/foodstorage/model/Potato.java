package ru.job4j.lsp.foodstorage.model;

import java.time.LocalDate;

public class Potato extends Food {
    public Potato(String name, LocalDate createDate, LocalDate expireDate, double price) {
        super(name, createDate, expireDate, price);
    }
}
