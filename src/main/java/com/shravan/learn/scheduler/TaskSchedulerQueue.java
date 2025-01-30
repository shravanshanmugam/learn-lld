package com.shravan.learn.scheduler;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TaskSchedulerQueue {
    private final PriorityQueue<Task> pq;

    public TaskSchedulerQueue() {
        pq = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
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

    public synchronized boolean isEmpty() {
        return pq.isEmpty();
    }

    public synchronized Task peek() {
        return pq.peek();
    }

    public synchronized Task poll() {
        return pq.poll();
    }

    public synchronized void add(Task task) {
        pq.add(task);
    }

    public synchronized void remove(Task task) {
        pq.remove(task);
    }

    public synchronized void changePriority(Task task) {
        pq.remove(task);
        pq.add(task);
    }
}
