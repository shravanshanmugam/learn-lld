package com.shravan.learn.scheduler;

import java.util.Date;

public class TaskRunner implements Runnable {
    private final TaskSchedulerQueue queue;

    public TaskRunner(TaskSchedulerQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("running TaskRunner");
        while (true) {
            try {
                ScheduledTask task;
                while ((task = queue.poll()) != null) {
                    long waitTimeMs = task.getNextExecutionTime() - System.currentTimeMillis();
                    if (waitTimeMs > 0) {
                        synchronized (this) {
                            queue.add(task);
                            wait(waitTimeMs);
                        }
                    } else {
                        task.getEventHandler().onStart();
                        System.out.println("executing " + task + " at " + new Date(task.getNextExecutionTime()) + " epoch " + task.getNextExecutionTime() + " thread " + Thread.currentThread().getName());
                        task.getEventHandler().onEnd();
                        if (task.isRecurring()) {
                            queue.add(task.nextScheduledTask());
                        }
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
