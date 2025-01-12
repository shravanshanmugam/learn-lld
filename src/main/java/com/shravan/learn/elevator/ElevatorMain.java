package com.shravan.learn.elevator;

public class ElevatorMain {
    public static void main(String[] args) {
        ElevatorManager elevatorManager = new ElevatorManager(1);
        elevatorManager.request(1, 4);
        elevatorManager.request(5, 7);
        elevatorManager.request(9, 2);
        elevatorManager.request(1,7);
    }
}
