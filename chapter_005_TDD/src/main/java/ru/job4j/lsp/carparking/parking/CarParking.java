package ru.job4j.lsp.carparking.parking;

import ru.job4j.lsp.carparking.car.Car;

public class CarParking implements Parking {

    private int carLimit;

    private Car[] carStorage = new Car[carLimit];

    public CarParking(int carLimit) {
        this.carLimit = carLimit;
    }

    @Override
    public boolean park(Car car) {
        return false;
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
