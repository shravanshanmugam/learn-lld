package com.shravan.learn.elevator;

import java.util.LinkedList;
import java.util.Queue;

public class Elevator {
    private final int id;
    private int currentFloor;
    private Direction currentDirection;
    private final Queue<Request> requests;

    public Elevator(int id) {
        this.id = id;
        currentFloor = 0;
        currentDirection = Direction.UP;
        requests = new LinkedList<>();
    }

    public void addRequest(Request request) {
        requests.add(request);
    }

    private void processRequests() {
        while (true) {
            while (!requests.isEmpty()) {
                Request request = requests.poll();
                processRequest(request);
            }
        }
    }

    private void processRequest(Request request) {
        int startFloor = request.getSource();
        // Go to source
        if (currentFloor < startFloor) {
            currentDirection = Direction.UP;
            for (int i = currentFloor; i <= startFloor; i++) {
                currentFloor = i;
                sleep();
            }
            print();
        } else if (currentFloor > startFloor) {
            for (int i = currentFloor; i >= startFloor; i--) {
                currentFloor = i;
                sleep();
            }
            print();
        }
        int endFloor = request.getDestination();
        // Go to destination
        if (startFloor < endFloor) {
            currentDirection = Direction.UP;
            for (int i = startFloor; i <= endFloor; i++) {
                currentFloor = i;
                sleep();
            }
            print();
        } else if (startFloor > endFloor) {
            currentDirection = Direction.DOWN;
            for (int i = startFloor; i >= endFloor; i--) {
                currentFloor = i;
                sleep();
            }
            print();
        }
    }

    private void print() {
        System.out.println("Elevator " + id + " reached floor " + currentFloor);
    }

    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            //
        }
    }

    public void run() {
        processRequests();
    }

    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

}
