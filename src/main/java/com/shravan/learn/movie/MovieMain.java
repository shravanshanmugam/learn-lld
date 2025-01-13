package com.shravan.learn.movie;

// MovieBookingSystem -> Movies, Theaters, Shows, Bookings
// bookTickets(User, Show, list Seats) -> areSeatsAvailable(Show, list Seats) -> markSeatsAsBooked, calculateTotalPrice, createBooking
// confirmBooking(bookingId) -> BookingStatus.CONFIRMED
// cancelBooking(bookingId) -> BookingStatus.CANCELLED, markSeatsAsAvailable

// Booking -> User, Show, list Seats, totalPrice, BookingStatus,
// BookingStatus -> PENDING, CONFIRMED, CANCELLED

// Show -> Movie, Theater, startTime (LocalDateTime), endTime (LocalDateTime), map Seats (key row-column)
// Theater -> name, location, list Seats
// Seat -> row, column, SeatType, SeatStatus, price
// SeatType -> NORMAL, PREMIUM
// SeatStatus -> AVAILABLE, BOOKED
// Movie -> title, description, durationInMinutes

// User -> name, email
public class MovieMain {
    public static void main(String[] args) {

    }
}
