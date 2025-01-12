package com.shravan.learn.trafficsignal;

import java.util.*;

public class TrafficController {

    private static TrafficController instance = new TrafficController();
    private final Map<String, Road> roads;
    Deque<TrafficLight> q = new LinkedList<>();

    private TrafficController() {
        roads = new LinkedHashMap<>();
    }

    public static TrafficController getInstance() {
        return instance;
    }

    public void addRoad(Road road) {
        roads.put(road.getId(), road);
    }

    public void startTrafficControl() {
        for (Road road : roads.values()) {
            q.add(road.getTrafficLight());
        }
        print();
        new Thread(() -> {
            while(true) {
                try {
                    TrafficLight current = q.poll();
                    current.changeSignal(Signal.GREEN);
                    print();
                    Thread.sleep(current.getGreenDuration());
                    current.changeSignal(Signal.YELLOW);
                    Thread.sleep(current.getYellowDuration());
                    current.changeSignal(Signal.RED);
                    q.add(current);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    private void print() {
        Iterator<TrafficLight> iterator = q.iterator();
        while (iterator.hasNext()) {
            TrafficLight next = iterator.next();
            System.out.println("next = " + next);
        }
    }

    public void handleEmergency(String roadId) {
        Road road = roads.get(roadId);
        TrafficLight trafficLight = road.getTrafficLight();
        boolean removed = q.remove(trafficLight);
        System.out.println("removed " + trafficLight.getId() + " " + removed);
        print();
        if (removed) {
            q.offerFirst(trafficLight);
            System.out.println("added to front " + trafficLight.getId());
            print();
        }
    }
}
