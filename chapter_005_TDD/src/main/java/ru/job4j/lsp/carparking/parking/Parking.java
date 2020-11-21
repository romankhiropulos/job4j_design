package ru.job4j.lsp.carparking.parking;

import ru.job4j.lsp.carparking.car.Car;

import java.util.List;

public interface Parking {

    boolean park(Car car);

    int getParkingSize();

    List<Car> getAllCar();

    Car getCar(Car car);

}
