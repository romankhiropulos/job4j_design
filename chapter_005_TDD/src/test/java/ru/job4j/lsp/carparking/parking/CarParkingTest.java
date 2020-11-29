package ru.job4j.lsp.carparking.parking;

import org.junit.Test;
import ru.job4j.lsp.carparking.car.Car;
import ru.job4j.lsp.carparking.car.PassengerCar;
import ru.job4j.lsp.carparking.car.Truck;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CarParkingTest {

    @Test
    public void whenParkTruckAndNoPlaceThen() {
        Car truck = new Truck();
        Parking parking = new CarParking(4, 0);
        parking.park(truck);
        assertThat(parking.getParkingSize(), is(1));
    }

    @Test
    public void whenParkThen() {
        Car truck = new PassengerCar();
        Parking parking = new CarParking(10, 3);
        parking.park(truck);
        assertThat(parking.getParkingSize(), is(1));
        assertThat(parking.getCar(truck), is(truck));
    }

    @Test
    public void getParkingSize() {
        Car truck = new Truck();
        Parking parking = new CarParking(10, 2);
        parking.park(truck);
        assertThat(parking.getParkingSize(), is(1));
    }

    @Test
    public void getAllCar() {
        Car car = new PassengerCar();
        Car truck = new Truck();
        Parking parking = new CarParking(10, 2);
        parking.park(car);
        parking.park(truck);
        assertThat(parking.getAllCar(), is(new ArrayList<>(Arrays.asList(car, truck))));
    }

    @Test
    public void getCar() {
        Car truck = new Truck();
        Parking parking = new CarParking(10, 2);
        parking.park(truck);
        assertThat(parking.getCar(truck), is(truck));
        assertThat(parking.getParkingSize(), is(1));
    }
}