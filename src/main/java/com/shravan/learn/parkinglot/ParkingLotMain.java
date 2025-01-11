package com.shravan.learn.parkinglot;

import com.shravan.learn.parkinglot.vehicletype.Bike;
import com.shravan.learn.parkinglot.vehicletype.Car;
import com.shravan.learn.parkinglot.vehicletype.Vehicle;
import com.shravan.learn.parkinglot.vehicletype.VehicleType;

import java.util.ArrayList;
import java.util.List;

// ParkingLot -> Level -> ParkingSpot -> spotNumber, vehicleType, parkedVehicle
public class ParkingLotMain {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();

        List<ParkingSpot> level1 = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            level1.add(new ParkingSpot(i, VehicleType.BIKE));
        }
        for (int i = 6; i <= 10; i++) {
            level1.add(new ParkingSpot(i, VehicleType.CAR));
        }
        parkingLot.addLevel(new Level(1, level1));

        List<ParkingSpot> level2 = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            level2.add(new ParkingSpot(i, VehicleType.BIKE));
        }
        for (int i = 7; i <= 10; i++) {
            level2.add(new ParkingSpot(i, VehicleType.CAR));
        }
        parkingLot.addLevel(new Level(2, level2));

        Vehicle car = new Car("ABC123");
        Vehicle bike = new Bike("XYZ456");

        parkingLot.park(car);
        parkingLot.park(bike);
        parkingLot.display();
        parkingLot.unpark(bike);
        parkingLot.display();
    }
}
