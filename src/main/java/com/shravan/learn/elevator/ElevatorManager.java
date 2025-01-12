package com.shravan.learn.elevator;

import java.util.*;

public class ElevatorManager {
    private final List<Elevator> elevators;

    public ElevatorManager(int num) {
        this.elevators = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Elevator elevator = new Elevator(i + 1);
            elevators.add(elevator);
            new Thread(elevator::run).start();
        }
    }

    public void request(int source, int destination) {
        Elevator optimalElevator = findOptimalElevator(source, destination);
        optimalElevator.addRequest(new Request(source, destination));
    }

    private Elevator findOptimalElevator(int source, int destination) {
        Elevator optimalElevator = null;
        int minDistance = Integer.MAX_VALUE;
        for (Elevator elevator : elevators) {
            int distance = Math.abs(elevator.getCurrentFloor() - source);
            if (distance < minDistance) {
                minDistance = distance;
                optimalElevator = elevator;
            }
        }
        return optimalElevator;
    }
}
