package com.shravan.learn.hotelmanagementsystem;

import java.util.Objects;

public class Room {
    private final String roomNumber;
    private final RoomType roomType;
    private RoomStatus status;

    public Room(String roomNumber, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.status = RoomStatus.AVAILABLE;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return Objects.equals(roomNumber, room.roomNumber) && roomType == room.roomType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, roomType);
    }

    public void checkIn() {
        status = RoomStatus.OCCUPIED;
    }

    public void checkOut() {
        status = RoomStatus.AVAILABLE;
    }
}
