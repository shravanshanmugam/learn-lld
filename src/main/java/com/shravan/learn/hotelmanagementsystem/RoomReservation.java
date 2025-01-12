package com.shravan.learn.hotelmanagementsystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class RoomReservation {
    private final String reservationId;
    private final Room room;
    private final Customer customer;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private ReservationStatus status;
    private final int totalPrice;


    public RoomReservation(Room room, Customer customer, LocalDate startDate, LocalDate endDate) {
        this.reservationId = generateReservationId();
        this.room = room;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = calculateTotalPrice();
        this.status = ReservationStatus.CONFIRMED;
    }

    private int calculateTotalPrice() {
        int days = (int) ChronoUnit.DAYS.between(startDate, endDate) + 1;
        return room.getRoomType().getPrice() * days;
    }

    public void cancel() {
        if (status.equals(ReservationStatus.CONFIRMED)) {
            status = ReservationStatus.CANCELLED;
        }
    }

    private String generateReservationId() {
        assert room != null;
        return "RES" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public String getReservationId() {
        return reservationId;
    }

    public Room getRoom() {
        return room;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
