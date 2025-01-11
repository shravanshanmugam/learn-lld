package com.shravan.learn.parkinglot;

import com.shravan.learn.parkinglot.vehicletype.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static ParkingLot instance;
    private final List<Level> levels;

    private ParkingLot() {
        this.levels = new ArrayList<>();
    }

    public static synchronized ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addLevel(Level level) {
        levels.add(level);
    }

    public boolean park(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.park(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public boolean unpark(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.unpark(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public void display() {
        for (Level level : levels) {
            level.display();
        }
        System.out.println("=====");
    }
}
