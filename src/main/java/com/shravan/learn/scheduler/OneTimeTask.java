package com.shravan.learn.scheduler;

public class OneTimeTask extends ScheduledTask {

    private final long nextExecutionTime;
    public OneTimeTask(int priority, EventHandler eventHandler, long nextExecutionTime) {
        super(priority, eventHandler);
        this.nextExecutionTime = nextExecutionTime;
    }

    @Override
    long getNextExecutionTime() {
        return nextExecutionTime;
    }

    @Override
    boolean isRecurring() {
        return false;
    }

    @Override
    ScheduledTask nextScheduledTask() {
        return null;
    }
}
