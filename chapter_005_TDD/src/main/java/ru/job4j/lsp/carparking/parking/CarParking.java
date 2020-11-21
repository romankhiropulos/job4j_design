package ru.job4j.lsp.carparking.parking;

import ru.job4j.lsp.carparking.car.Car;

import java.util.*;

/**
 * !!!Легковая машина может занять только место, предназначенное для легковой машины!!!
 * Грузовая машина может разместиться на месте, предназначенном для грузовых машин,
 * либо на N парковочных мест для легковых машин, стоящих рядом.
 */
public class CarParking implements Parking {

    private final int passengerCarLimit;
    private final int truckLimit;

    private int passengerCarCount;
    private int truckCount;

    private int passengerCarStorageSize;
    private int truckStorageSize;

    private final Car[] passengerCarStorage;
    private final Car[] truckStorage;

    public CarParking(int passengerCarLimit, int truckLimit) {
        this.passengerCarLimit = passengerCarLimit;
        this.truckLimit = truckLimit;
        passengerCarStorage = new Car[passengerCarLimit];
        truckStorage = new Car[truckLimit];
    }

    @Override
    public boolean park(Car car) {
        if (car.getCarSize() == 1) {
            if (passengerCarStorageSize < passengerCarLimit) {
                passengerCarStorage[passengerCarStorageSize] = car;
                passengerCarCount++;
                passengerCarStorageSize++;
            } else {
                return false;
            }
        } else if (car.getCarSize() == 3) {
            if (truckStorageSize < truckLimit) {
                truckStorage[truckStorageSize] = car;
                truckCount++;
                truckStorageSize++;
            } else {
                if (passengerCarLimit - passengerCarStorageSize >= 3) {
                    passengerCarStorage[passengerCarStorageSize] = car;
                    truckCount++;
                    passengerCarStorageSize = passengerCarStorageSize + 3;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    @Override
    public List<Car> getAllCar() {
        List<Car> cars = new ArrayList<>();
        Arrays.stream(passengerCarStorage).filter(Objects::nonNull).forEach(cars::add);
        Arrays.stream(truckStorage).filter(Objects::nonNull).forEach(cars::add);
        return cars;
    }

    @Override
    public Car getCar(Car car) {
        Optional<Car> result = Optional.empty();
        if (car.getCarSize() == 3) {
            result = Arrays.stream(truckStorage).filter(searchCar -> searchCar.equals(car)).findFirst();
        }
        if (car.getCarSize() == 1 || (result.isEmpty() && truckCount > 0)) {
            result = Arrays.stream(passengerCarStorage).filter(searchCar -> searchCar.equals(car)).findFirst();
        }
        return result.orElse(null);
    }

    @Override
    public int getParkingSize() {
        return passengerCarCount + truckCount;
    }
}
