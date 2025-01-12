package com.shravan.learn.carrental;

import java.time.LocalDate;
import java.util.List;

// CarBookingSystem -> Cars, CarBookings
// Car - make, model, licensePlate, price
// CarBooking - car, user, startDate, endDate, totalPrice
public class CarRentalSystemMain {
    public static void main(String[] args) {
        CarBookingSystem carBookingSystem = CarBookingSystem.getInstance();
        for (int i = 0; i < 3; i++) {
            Car car = new Car("abc12" + i);
            car.setMake("Audi");
            car.setModel("A1");
            car.setPrice(100);
            carBookingSystem.addCar(car);
        }

        for (int i = 0; i < 1; i++) {
            Car car = new Car("xyz12" + i);
            car.setMake("Audi");
            car.setModel("A2");
            car.setPrice(200);
            carBookingSystem.addCar(car);
        }

        LocalDate start1 = LocalDate.of(2025, 1, 15);
        LocalDate end1 = LocalDate.of(2025, 1, 20);
        List<Car> search1 = carBookingSystem.search("Audi", "A3", 50, 150, start1, end1);
        System.out.println("search1 = " + search1);
        List<Car> search2 = carBookingSystem.search("Audi", "A1", 50, 150, start1, end1);
        System.out.println("search2 = " + search2);
        List<Car> search3 = carBookingSystem.search("Audi", "A1", 110, 150, start1, end1);
        System.out.println("search3 = " + search3);

        List<Car> search4 = carBookingSystem.search("Audi", "A2", 150, 240, start1, end1);
        System.out.println("search4 = " + search4);
        CarBooking booking1 = carBookingSystem.reserve(search4.get(0), new User("shravan"), start1, end1);
        System.out.println("booking1 = " + booking1);
        carBookingSystem.showBookings();

        LocalDate start2 = LocalDate.of(2025, 1, 17);
        LocalDate end2 = LocalDate.of(2025, 1, 20);
        List<Car> search5 = carBookingSystem.search("Audi", "A2", 150, 240, start2, end2);
        System.out.println("search5 = " + search5);

        carBookingSystem.cancel(booking1.getId());
        carBookingSystem.showBookings();

        List<Car> search6 = carBookingSystem.search("Audi", "A2", 150, 240, start2, end2);
        System.out.println("search5 = " + search6);

    }

}
