package com.shravan.learn.scheduler;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public abstract class ScheduledTask {
    private final int id;
    private int priority;
    private EventHandler eventHandler;
    private static final AtomicInteger counter = new AtomicInteger(0);
    public ScheduledTask(int id, int priority, EventHandler eventHandler) {
        this.id = id;
        this.priority = priority;
        this.eventHandler = eventHandler;
    }
    public ScheduledTask(int priority, EventHandler eventHandler) {
        this.id = counter.incrementAndGet();
        this.priority = priority;
        this.eventHandler = eventHandler;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    abstract long getNextExecutionTime();

    abstract boolean isRecurring();

    abstract ScheduledTask nextScheduledTask();

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ScheduledTask)) return false;
        ScheduledTask that = (ScheduledTask) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
