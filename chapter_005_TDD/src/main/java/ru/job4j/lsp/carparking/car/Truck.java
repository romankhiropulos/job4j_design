package ru.job4j.lsp.carparking.car;

public class Truck implements Car {

    private static final int SIZE_TRACK = 3;

    private final int sizeCar;

    public Truck() {
        this.sizeCar = SIZE_TRACK;
    }

    public Truck(int sizeCar) {
        this.sizeCar = sizeCar;
    }

    @Override
    public int getCarSize() {
        return sizeCar;
    }
}
