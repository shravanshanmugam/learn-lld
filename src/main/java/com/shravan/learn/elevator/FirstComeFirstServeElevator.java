package com.shravan.learn.elevator;

import java.util.*;

public class FirstComeFirstServeElevator {
    private final int id;
    private final int floors;
    private int currentFloor;
    private Direction currentDirection;
    private Queue<Integer> next;
    private TreeSet<Integer> set;
    private boolean[] pressed;

    public FirstComeFirstServeElevator(int id, int floors) {
        this.id = id;
        currentFloor = 0;
        currentDirection = Direction.UP;
        next = new LinkedList<>();
        this.floors = floors;
        pressed = new boolean[floors];
        set = new TreeSet<>();
        set.add(currentFloor);
    }

    public void addRequest(int where) {
        set.add(where);
        pressed[where] = true;
        next.add(where);
    }

    public void run() {
        while(true) {
            while (!next.isEmpty()) {
                Integer nextFloor = next.poll();
                Integer nearestLow = set.lower(currentFloor);
                if (nearestLow != null) {
                    System.out.println("nearestLow = " + nearestLow);
                }
                Integer nearestHigh = set.higher(currentFloor);
                if (nearestHigh != null) {
                    System.out.println("nearestHigh = " + nearestHigh);
                }
                System.out.println("nextFloor = " + nextFloor);
                processNext(nextFloor);
            }
            sleep();
        }
    }

    private void processNext(int nextFloor) {
        // Go to source
        if (currentFloor < nextFloor) {
            currentDirection = Direction.UP;
            for (int i = currentFloor; i < nextFloor; i++) {
                currentFloor = i;
                current();
                if (pressed[i]) {
                    pressed[i] = false;
                    next.remove(i);
                    System.out.println("reached inside " + i);
                    sleep(10000);
                }
                sleep(2000);
            }
        } else if (currentFloor > nextFloor) {
            for (int i = currentFloor; i > nextFloor; i--) {
                currentFloor = i;
                current();
                if (pressed[i]) {
                    pressed[i] = false;
                    next.remove(i);
                    System.out.println("reached inside " + i);
                    sleep(10000);
                }
                sleep(2000);
            }
        }
        currentFloor = nextFloor;
        pressed[currentFloor] = false;
        reached();
        sleep(10000);
    }

    private void current() {
        System.out.println("Elevator " + id + " currently at floor " + currentFloor);
    }

    private void reached() {
        System.out.println("Elevator " + id + " reached floor " + currentFloor);
    }

    private static void sleep() {
        sleep(1000);
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            //
        }
    }

    public static void main(String[] args) {
        FirstComeFirstServeElevator elevator = new FirstComeFirstServeElevator(1, 100);
        new Thread(elevator::run).start();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Press: ");
            int next = scanner.nextInt();
            if (next == -1) break;
            elevator.addRequest(next);
        }
    }
}
