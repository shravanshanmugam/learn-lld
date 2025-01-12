package com.shravan.learn.carrental;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CarBookingSystem {
    private static CarBookingSystem instance = new CarBookingSystem();
    private List<Car> cars;
    private List<CarBooking> carBookings;

    private CarBookingSystem() {
        cars = new ArrayList<>();
        carBookings = new ArrayList<>();
    }

    public static CarBookingSystem getInstance() {
        return instance;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public List<Car> search(String make, String model, int minPrice, int maxPrice) {
        List<Car> results = new ArrayList<>();
        for (Car car : cars) {
            if (make.equals(car.getMake()) && model.equals(car.getModel())) {
                if (minPrice <= car.getPrice() && car.getPrice() <= maxPrice) {
                    results.add(car);
                }
            }
        }
        return results;
    }

    public List<Car> search(String make, String model, int minPrice, int maxPrice, LocalDate startDate, LocalDate endDate) {
        List<Car> searchResults = search(make, model, minPrice, maxPrice);
        List<Car> availableCars = new ArrayList<>();
        for (Car car : searchResults) {
            if (isAvailable(car, startDate, endDate)) {
                availableCars.add(car);
            }
        }
        return availableCars;
    }

    public CarBooking reserve(Car car, User user, LocalDate startDate, LocalDate endDate) {
        if (isAvailable(car, startDate, endDate)) {
            CarBooking carBooking = new CarBooking(carBookings.size() + 1, car, user, startDate, endDate);
            carBookings.add(carBooking);
            return carBooking;
        }
        throw new IllegalStateException("Car not available");
    }

    public void cancel(int id) {
        carBookings.removeIf(cb -> cb.getId() == id);
    }

    private boolean isAvailable(Car car, LocalDate startDate, LocalDate endDate) {
        for (CarBooking carBooking : carBookings) {
            if (carBooking.getCar().equals(car)) {
                boolean available = endDate.isBefore(carBooking.getStartDate()) || startDate.isAfter(carBooking.getEndDate());
                if (!available) {
                   return false;
                }
            }
        }
        return true;
    }

    public void showBookings() {
        System.out.print("Bookings = ");
        System.out.println(carBookings);
    }
}
