package com.shravan.learn.trafficsignalsystem;

// TrafficController -> Roads + queue -> Traffic Light -> current signal, yellow duration, green duration
public class TrafficSignalSystemMain {

    public static void main(String[] args) throws InterruptedException {
        TrafficController trafficController = TrafficController.getInstance();

        // Create roads
        Road road1 = new Road("R1", "Main Street");
        Road road2 = new Road("R2", "Broadway");
        Road road3 = new Road("R3", "Park Avenue");
        Road road4 = new Road("R4", "Elm Street");

        // Create traffic signals
        TrafficLight trafficLight1 = new TrafficLight("TL1", 5000, 10000);
        TrafficLight trafficLight2 = new TrafficLight("TL2", 5000, 20000);
        TrafficLight trafficLight3 = new TrafficLight("TL3", 5000, 15000);
        TrafficLight trafficLight4 = new TrafficLight("TL4", 5000, 10000);

        // assign traffic lights to roads
        road1.setTrafficLight(trafficLight1);
        road2.setTrafficLight(trafficLight2);
        road3.setTrafficLight(trafficLight3);
        road4.setTrafficLight(trafficLight4);

        // add roads to traffic controller
        trafficController.addRoad(road1);
        trafficController.addRoad(road2);
        trafficController.addRoad(road3);
        trafficController.addRoad(road4);

        // Start traffic control
        trafficController.startTrafficControl();

        Thread.sleep(5000);

        // handle emergency
        trafficController.handleEmergency("R3");
    }
}
