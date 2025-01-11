package com.shravan.learn.trafficsignalsystem;

import java.util.Objects;

public class TrafficLight {
    private final String id;
    private Signal current;
    private int yellowDuration;
    private int greenDuration;

    public TrafficLight(String id, int yellowDuration, int greenDuration) {
        this.id = id;
        this.yellowDuration = yellowDuration;
        this.greenDuration = greenDuration;
        this.current = Signal.RED;
    }

    public void changeSignal(Signal newSignal) {
        System.out.println("change " + id + " to " + newSignal);
        current = newSignal;
    }

    public String getId() {
        return id;
    }

    public Signal getCurrent() {
        return current;
    }

    public int getYellowDuration() {
        return yellowDuration;
    }

    public int getGreenDuration() {
        return greenDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TrafficLight that = (TrafficLight) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", current=" + current +
                '}';
    }
}
