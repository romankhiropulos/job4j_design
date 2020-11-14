package ru.job4j.lsp.foodstorage.model;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Food {
    String name;
    LocalDate createDate;
    LocalDate expireDate;
    double price;
    double discount;

    public Food(String name, LocalDate createDate, LocalDate expireDate, double price) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(createDate);
        Objects.requireNonNull(expireDate);
        this.name = name;
        this.createDate = createDate;
        this.expireDate = expireDate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void changePriceByDiscount() {
        price = price * (1 - discount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return Double.compare(food.price, price) == 0
                && Double.compare(food.discount, discount) == 0
                && Objects.equals(name, food.name)
                && Objects.equals(createDate, food.createDate)
                && Objects.equals(expireDate, food.expireDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, createDate, expireDate, price, discount);
    }
}
