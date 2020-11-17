package ru.job4j.lsp.carparking.car;

public class PassengerCar implements Car {

    private static final int SIZE_CAR = 1;

    private final int sizeCar;

    public PassengerCar() {
        this.sizeCar = SIZE_CAR;
    }

    public PassengerCar(int sizeCar) {
        this.sizeCar = sizeCar;
    }

    @Override
    public int getCarSize() {
        return sizeCar;
    }
}
