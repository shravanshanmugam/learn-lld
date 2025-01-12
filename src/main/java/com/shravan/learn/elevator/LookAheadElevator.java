package com.shravan.learn.elevator;

import java.util.Scanner;
import java.util.TreeSet;

public class LookAheadElevator {
    private final int id;
    private int currentFloor;
    private Direction currentDirection;
    private final TreeSet<Integer> set;

    public LookAheadElevator(int id) {
        this.id = id;
        currentFloor = 0;
        currentDirection = Direction.UP;
        set = new TreeSet<>();
    }

    public void addRequest(int where) {
        set.add(where);
    }

    public void run() {
        while(true) {
            while (!set.isEmpty()) {
                int nearest = nearest();
                System.out.println("nearest = " + nearest);
                if (currentFloor != nearest) {
                    if (currentDirection.equals(Direction.UP)) {
                        do {
                            sleep(2000);
                            currentFloor++;
                            current();
                            if (currentFloor == nearest) {
                                stop();
                            }
                            Integer newNearest = set.higher(currentFloor);
                            if (newNearest != null && nearest != newNearest) {
                                System.out.println("newNearest higher = " + newNearest);
                                nearest = newNearest;
                            }
                            set.remove(currentFloor);
                        } while (currentFloor != nearest);
                    } else {
                        do {
                            sleep(2000);
                            currentFloor--;
                            current();
                            if (currentFloor == nearest) {
                                stop();
                            }
                            Integer newNearest = set.lower(currentFloor);
                            if (newNearest != null && nearest != newNearest) {
                                System.out.println("newNearest lower = " + newNearest);
                                nearest = newNearest;
                            }
                            set.remove(currentFloor);

                        } while (currentFloor != nearest);
                    }
                } else {
                    set.remove(currentFloor);
                }

                sleep();
            }
            sleep();
        }
    }

    private int nearest() {
        Integer nearestLow = set.lower(currentFloor);
        Integer nearestHigh = set.higher(currentFloor);
        if (nearestHigh != null && nearestLow != null) {
            int higher = Math.abs(currentFloor - nearestHigh);
            int lower = Math.abs(currentFloor - nearestLow);
            if (higher <= lower) {
                currentDirection = Direction.UP;
                return nearestHigh;
            } else {
                currentDirection = Direction.DOWN;
                return nearestLow;
            }
        }
        if (nearestHigh != null) {
            currentDirection = Direction.UP;
            return nearestHigh;
        }
        if (nearestLow != null) {
            currentDirection = Direction.DOWN;
            return nearestLow;
        }
        return currentFloor;

    }

    private void stop() {
        System.out.println("Elevator " + id + " stopped at floor ***** " + currentFloor + " *****, set " + set);
    }

    private void current() {
        System.out.println("Elevator " + id + " currently at floor " + currentFloor + ", set " + set);
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
        LookAheadElevator elevator = new LookAheadElevator(1);
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
