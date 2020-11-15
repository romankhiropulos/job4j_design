package ru.job4j.lsp.carparking.parking;

import ru.job4j.lsp.carparking.car.Car;

public class CarParking extends AbstractParking {

    public CarParking(int carLimit) {
        super(carLimit);
    }

    @Override
    public boolean park(Car car) {
        return false;
    }
}
