package ru.job4j.lsp.carparking;

import ru.job4j.lsp.carparking.car.Car;
import ru.job4j.lsp.carparking.car.PassengerCar;
import ru.job4j.lsp.carparking.car.Truck;
import ru.job4j.lsp.carparking.parking.CarParking;
import ru.job4j.lsp.carparking.parking.Parking;

public class ControllerParking {
    private static final Parking PARKING_1 = new CarParking(10, 5);
    private static final Parking PARKING_2 = new CarParking(5, 6);

    private static final Car PASSENGER_CAR_1 = new PassengerCar();
    private static final Car PASSENGER_CAR_2 = new PassengerCar();
    private static final Car TRUCK_1 = new Truck();
    private static final Car TRUCK_2 = new Truck();

    void startParkingWork(Parking parking, Car... cars) {
        for (Car car : cars) {
            parking.park(car);
        }
    }

    public static void main(String[] args) {
        new ControllerParking().startParkingWork(PARKING_1, PASSENGER_CAR_1, PASSENGER_CAR_2, TRUCK_1);
        new ControllerParking().startParkingWork(PARKING_2, TRUCK_2);
    }
}
