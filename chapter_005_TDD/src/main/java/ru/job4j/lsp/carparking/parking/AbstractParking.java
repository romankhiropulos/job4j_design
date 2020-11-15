package ru.job4j.lsp.carparking.parking;

import ru.job4j.lsp.carparking.car.Car;

public abstract class AbstractParking implements Parking {

    private int carLimit;

    Car[] carStorage = new Car[carLimit];

    public AbstractParking(int carLimit) {
        this.carLimit = carLimit;
    }

    @Override
    public int getParkingSize() {
        return carLimit;
    }

    @Override
    public Car[] getParkingStorages() {
        return carStorage;
    }
}
