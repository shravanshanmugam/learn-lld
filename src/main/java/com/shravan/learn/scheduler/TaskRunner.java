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
            while (!queue.isEmpty()) {
                Task task;
                long waitTimeMs;
                do {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    task = queue.peek();
                    waitTimeMs = task.getNextExecutionTime() - System.currentTimeMillis();
                } while (waitTimeMs > 0);
                task = queue.poll();
                if (!task.isDone()) {
                    task.getTaskEventHandler().onStart();
                    System.out.println("executing " +task + " at " + new Date(task.getNextExecutionTime()) + " epoch " + task.getNextExecutionTime() + " thread " + Thread.currentThread().getName());
                    task.getTaskEventHandler().onEnd();
                    if (ScheduleType.RECURRING.equals(task.getScheduleType())) {
                        long nextExecutionTime = task.getNextExecutionTime() + task.getPeriod();
                        task.setNextExecutionTime(nextExecutionTime);
                        queue.add(task);
                    } else if (ScheduleType.FIXED_DATE.equals(task.getScheduleType())) {
                        task.setDone();
                    }
                }



            }
        }
    }
}
