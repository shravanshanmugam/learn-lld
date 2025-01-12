package com.shravan.learn.airline;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

// AirlineManagement -> Flights, FlightSearch(Flights), BookingManager,
//                      addFlight, searchFlights, bookFlight, cancelBooking

// Flight -> flightNumber, source, destination, departureTime (LocalDateTime), arrivalTime (LocalDateTime), Seats
// FlightSearch -> Flights, search(source, destination, departureDate (LocalDate))

// Booking -> bookingNumber, Flight, Passenger, Seat, price, BookingStatus
// BookingStatus -> CONFIRMED, CANCELLED, PENDING, EXPIRED
// BookingManager -> Bookings, createBooking, cancelBooking

// Seat -> seatNumber, SeatType, SeatStatus
// SeatType -> ECONOMY, BUSINESS, FIRST_CLASS
// SeatStatus -> AVAILABLE, RESERVED, OCCUPIED
public class AirlineMain {
    public static void main(String[] args) {

    }

    private final AtomicInteger bookingCounter = new AtomicInteger(0);
    private String generateBookingNumber() {
        int bookingId = bookingCounter.incrementAndGet();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return "BKG" + timestamp + String.format("%06d", bookingId);
    }
}
