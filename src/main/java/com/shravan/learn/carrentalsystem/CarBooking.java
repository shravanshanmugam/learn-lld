package com.shravan.learn.carrentalsystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CarBooking {
    private final int id;
    private final Car car;
    private final User user;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final int totalPrice;

    public CarBooking(int id, Car car, User user, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.car = car;
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = calculateTotalPrice();
    }

    private int calculateTotalPrice() {
        int days = (int) (ChronoUnit.DAYS.between(startDate, endDate) + 1);
        return car.getPrice() * days;
    }

    public int getId() {
        return id;
    }

    public Car getCar() {
        return car;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", car=" + car +
                ", user=" + user +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
