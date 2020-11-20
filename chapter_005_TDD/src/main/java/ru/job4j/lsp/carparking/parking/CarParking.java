package ru.job4j.lsp.carparking.parking;

import ru.job4j.lsp.carparking.car.Car;

import java.util.List;

/**
 * !!!Легковая машина может занять только место, предназначенное для легковой машины!!!
 * Грузовая машина может разместиться на месте, предназначенном для грузовых машин,
 * либо на N парковочных мест для легковых машин, стоящих рядом.
 */
public class CarParking implements Parking {

    private int passengerCarLimit;
    private int truckLimit;

    private final Car[] passengerCarStorage = new Car[passengerCarLimit];
    private final Car[] truckStorage = new Car[truckLimit];

    public CarParking(int passengerCarLimit, int truckLimit) {
        this.passengerCarLimit = passengerCarLimit;
        this.truckLimit = truckLimit;
    }

    @Override
    public boolean park(Car car) {
        return false;
    }

    @Override
    public int getParkingSize() {
        return 3;
    }

    @Override
    public List<Car> getAllCar() {
        return null;
    }

    @Override
    public Car getBackCar(Car car) {
        return car;
    }
}
