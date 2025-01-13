package com.shravan.learn.hotelmanagement;


// HMS -> Hotel, map RoomReservations
// isAvailable(Room, startDate, endDate)
// reserve(Customer, RoomType, startDate, endDate) -> isAvailable(), createReservation()
// cancel(reservationId)
// checkIn(reservationId) -> Room.checkIn()
// checkOut(reservationId) -> payment.process(), Room.checkOut()

// RoomReservation -> Room, Customer, checkIn (LocalDate) checkout (LocalDate), ReservationStatus, totalPrice
// ReservationStatus -> CONFIRMED, CANCELLED
// Hotel -> map Rooms by room type,
// Room -> roomNumber, RoomType, RoomStatus,
// checkIn(), checkOut()
// RoomStatus -> AVAILABLE, OCCUPIED
// RoomType -> SINGLE, DOUBLE, DELUXE, SUIT
public class HotelManagementSystemMain {
    public static void main(String[] args) {

    }
}
