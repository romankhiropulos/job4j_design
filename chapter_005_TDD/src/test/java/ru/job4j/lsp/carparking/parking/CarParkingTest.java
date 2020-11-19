package ru.job4j.lsp.carparking.parking;

import org.junit.Test;
import ru.job4j.lsp.carparking.car.Car;
import ru.job4j.lsp.carparking.car.PassengerCar;
import ru.job4j.lsp.carparking.car.Truck;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CarParkingTest {

    @Test
    public void park() {
        Car truck = new Truck();
        Parking parking = new CarParking(10);
        parking.park(truck);
        assertThat(parking.getBackCar(truck), is(truck));
    }

    @Test
    public void getParkingSize() {
        Car truck = new Truck();
        Parking parking = new CarParking(10);
        parking.park(truck);
        assertThat(parking.getParkingSize(), is(1));
    }

    @Test
    public void getParkingStorages() {
        Car car = new PassengerCar();
        Car truck = new Truck();
        Parking parking = new CarParking(10);
        parking.park(car);
        parking.park(truck);

        assertThat(parking.getParkingStorages(), is(new Car[]{car, truck}));
    }

    @Test
    public void getBackCar() {
        Car truck = new Truck();
        Parking parking = new CarParking(10);
        parking.park(truck);
        assertThat(parking.getBackCar(truck), is(truck));
        assertThat(parking.getParkingSize(), is(0));
    }
}