package com.shravan.learn.hotelmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Hotel {
    private final Map<RoomType, List<Room>> roomsByRoomType;

    public Hotel(Map<RoomType, List<Room>> roomsByRoomType) {
        this.roomsByRoomType = roomsByRoomType;
    }

    public List<Room> search(RoomType roomType) {
        return roomsByRoomType.getOrDefault(roomType, new ArrayList<>());
    }
}
