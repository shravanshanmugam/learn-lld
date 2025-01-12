package com.shravan.learn.hotelmanagement;

import java.time.LocalDate;
import java.util.*;

public class HotelManager {
    private final Hotel hotel;
    private final Map<String, RoomReservation> reservations;

    public HotelManager(Hotel hotel) {
        this.hotel = hotel;
        this.reservations = new HashMap<>();
    }

    public RoomReservation reserve(Customer customer, RoomType roomType, LocalDate startDate, LocalDate endDate) {
        List<Room> rooms = hotel.search(roomType);
        for (Room room : rooms) {
            if (isAvailable(room, startDate, endDate)) {
                RoomReservation roomReservation = new RoomReservation(room, customer, startDate, endDate);
                reservations.put(roomReservation.getReservationId(), roomReservation);
                return roomReservation;
            }
        }
        return null;
    }

    public void cancelReservation(String reservationId) {
        RoomReservation roomReservation = reservations.get(reservationId);
        if (roomReservation != null) {
            roomReservation.cancel();
            reservations.remove(reservationId);
        }
    }

    public void checkIn(String reservationId) {
        RoomReservation roomReservation = reservations.get(reservationId);
        if (roomReservation != null && roomReservation.getStatus().equals(ReservationStatus.CONFIRMED)) {
            roomReservation.getRoom().checkIn();
        }
    }

    public void checkOut(String reservationId, Payment payment) {
        RoomReservation roomReservation = reservations.get(reservationId);
        if (roomReservation != null && roomReservation.getStatus().equals(ReservationStatus.CONFIRMED)) {
            if (payment.process(roomReservation.getTotalPrice())) {
                roomReservation.getRoom().checkOut();
                reservations.remove(reservationId);
            }
        }
    }

    private boolean isAvailable(Room room, LocalDate startDate, LocalDate endDate) {
        List<RoomReservation> roomReservations = new ArrayList<>(reservations.values());
        for (RoomReservation roomReservation : roomReservations) {
            if (roomReservation.getRoom().equals(room)) {
                boolean available = endDate.isBefore(roomReservation.getStartDate()) || startDate.isAfter(roomReservation.getEndDate());
                if (!available) return false;
            }
        }
        return true;
    }
}
