package com.shravan.learn.parkinglot;

import com.shravan.learn.parkinglot.vehicletype.Vehicle;
import com.shravan.learn.parkinglot.vehicletype.VehicleType;

public class ParkingSpot {

    private final int spotNumber;
    private final VehicleType type;
    private Vehicle parked;

    public ParkingSpot(int spotNumber, VehicleType type) {
        this.spotNumber = spotNumber;
        this.type = type;
    }

    public boolean isAvailable() {
        return parked == null;
    }

    public void park(Vehicle vehicle) {
        if (isAvailable() && type.equals(vehicle.getType())) {
            parked = vehicle;
            return;
        }
        throw new IllegalArgumentException();

    }

    public void unpark() {
        parked = null;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public VehicleType getType() {
        return type;
    }

    public Vehicle getParked() {
        return parked;
    }
}
