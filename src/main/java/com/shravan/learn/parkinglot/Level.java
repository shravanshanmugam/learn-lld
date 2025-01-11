package com.shravan.learn.parkinglot;

import com.shravan.learn.parkinglot.vehicletype.Vehicle;

import java.util.List;

public class Level {
    private int floor;

    private List<ParkingSpot> parkingSpots;

    public Level(int floor, List<ParkingSpot> parkingSpots) {
        this.floor = floor;
        this.parkingSpots = parkingSpots;
    }

    public boolean park(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.isAvailable() && parkingSpot.getType() == vehicle.getType()) {
                parkingSpot.park(vehicle);
                return true;
            }
        }
        return false;
    }

    public boolean unpark(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (!parkingSpot.isAvailable() && parkingSpot.getParked().equals(vehicle)) {
                parkingSpot.unpark();
                return true;
            }
        }
        return false;
    }

    public int getFloor() {
        return floor;
    }

    public void display() {
        System.out.println("Level " + floor + " Availability");
        for (ParkingSpot parkingSpot : parkingSpots) {
            System.out.println("Spot " + parkingSpot.getSpotNumber() + ":" + (parkingSpot.isAvailable() ? "Available for " : "Occupied by ") + parkingSpot.getType());
        }
    }
}
