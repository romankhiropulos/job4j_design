package ru.job4j.lsp.carparking.parking;

import ru.job4j.lsp.carparking.car.Car;

public interface Parking {

    boolean park(Car car);

    int getParkingSize();

    Car[] getParkingStorages();
}
