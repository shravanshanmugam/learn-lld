package com.shravan.learn.scheduler;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskScheduler {
    private final List<Thread> threads;
    private final TaskRunner taskRunner;
    private final TaskSchedulerQueue queue;
    private int parallelism;

    public TaskScheduler(int noThreads) {
        queue = new TaskSchedulerQueue();
        taskRunner = new TaskRunner(queue);
        threads = new ArrayList<>();
        parallelism = noThreads;
        for (int i = 0; i < noThreads; i++) {
            Thread thread = new Thread(taskRunner);
            threads.add(thread);
            thread.start();
        }
    }

    public ScheduledTask schedule(ScheduledTask task) {
        queue.add(task);
        return task;
    }

    public void changePriority(ScheduledTask task, int priority) {
        queue.changePriority(task, priority);
    }

    public void cancel(ScheduledTask task) {
        queue.remove(task);
    }

    public void changeParallelism(int parallelism) {
        if (parallelism > this.parallelism) {
            int diff = parallelism - this.parallelism;
            for (int i = 0; i < diff; i++) {
                Thread thread = new Thread(taskRunner);
                threads.add(thread);
                thread.start();
            }
        } else if (parallelism < this.parallelism) {
            int diff = this.parallelism - parallelism;
            int i = diff;
            while (i-- >= 0) {
                Thread thread = threads.get(threads.size() - 1);
                thread.stop();
            }
        }
    }
}
