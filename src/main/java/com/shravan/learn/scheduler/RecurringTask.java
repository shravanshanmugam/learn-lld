package com.shravan.learn.scheduler;

public class RecurringTask extends ScheduledTask {
    private final long nextExecutionTime;
    private final long period;

    public RecurringTask(int priority, EventHandler eventHandler, long nextExecutionTime, long period) {
        super(priority, eventHandler);
        this.nextExecutionTime = nextExecutionTime;
        this.period = period;
    }

    public RecurringTask(int id, int priority, EventHandler eventHandler, long nextExecutionTime, long period) {
        super(id, priority, eventHandler);
        this.nextExecutionTime = nextExecutionTime;
        this.period = period;
    }

    @Override
    long getNextExecutionTime() {
        return nextExecutionTime;
    }

    @Override
    boolean isRecurring() {
        return true;
    }

    @Override
    ScheduledTask nextScheduledTask() {
        return new RecurringTask(getId(), getPriority(),getEventHandler(), nextExecutionTime + period, period);
    }
}
