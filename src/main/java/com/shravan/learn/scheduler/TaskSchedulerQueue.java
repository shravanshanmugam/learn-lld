package com.shravan.learn.scheduler;

import java.util.Comparator;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class TaskSchedulerQueue {
    private final PriorityBlockingQueue<ScheduledTask> pq;

    public TaskSchedulerQueue() {
        pq = new PriorityBlockingQueue<>(10, new Comparator<ScheduledTask>() {
            @Override
            public int compare(ScheduledTask o1, ScheduledTask o2) {
                if (o1.getNextExecutionTime() < o2.getNextExecutionTime()) {
                    return -1;
                } else if (o1.getNextExecutionTime() == o2.getNextExecutionTime()) {
                    return Integer.compare(o2.getPriority(), o1.getPriority());
                } else {
                    return 1;
                }
            }
        });
    }

    public boolean isEmpty() {
        return pq.isEmpty();
    }

    public ScheduledTask peek() {
        return pq.peek();
    }

    public ScheduledTask poll() {
        return pq.poll();
    }

    public void add(ScheduledTask task) {
        pq.add(task);
    }

    public void remove(ScheduledTask task) {
        pq.remove(task);
    }

    public void changePriority(ScheduledTask task, int priority) {
        Optional<ScheduledTask> first = pq.stream().filter(t -> t.getId() == task.getId()).findFirst();
        ScheduledTask scheduledTask = first.get();
        pq.remove(scheduledTask);
        scheduledTask.setPriority(priority);
        pq.add(scheduledTask);
    }
}
