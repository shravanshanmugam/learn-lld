package com.shravan.learn.concert;

// ConcertBookingSystem -> map Concerts, map Venues, map Bookings
// addConcert, getConcert, searchConcerts
// bookTickets(User, Concert, Seats) -> Seats.book(), processPayment(Booking), Booking.confirmBooking()
// cancelBooking(bookingId) -> Booking.cancelBooking()
// User -> name, email

// Booking -> User, Concert, Seats, totalPrice, BookingStatus
// calculateTotalPrice()
// confirmBooking()
// cancelBooking()
// BookingStatus -> PENDING, CONFIRMED, CANCELLED

// Concert -> artist, Venue, date
// Venue -> name, Seats,
// Seat -> seatNumber, SeatType, SeatStatus, price
// book()
// release()
// SeatType -> REGULAR, PREMIUM, VIP
// SeatStatus -> AVAILABLE, BOOKED, RESERVED
public class ConcertMain {
    public static void main(String[] args) {
    }
}
