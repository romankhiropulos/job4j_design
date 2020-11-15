package ru.job4j.lsp.carparking.car;

public abstract class AbstractCar implements Car {

    int sizeCar;

    @Override
    public int getCarSize() {
        return sizeCar;
    }
}
