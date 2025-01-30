package com.shravan.learn.scheduler;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskScheduler {
    private final Map<Integer, Task> tasks;
    private final AtomicInteger counter;
    private final List<Thread> threads;
    private final TaskRunner taskRunner;
    private final TaskSchedulerQueue queue;
    private int parallelism;

    public TaskScheduler(int noThreads) {
        tasks = new HashMap<>();
        counter = new AtomicInteger(0);
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

    public Task scheduleFixedDate(String taskName, TaskType taskType, int priority, ScheduleType scheduleType, Date fixedDate, TaskEventHandler taskEventHandler) {
        Task task = new Task(counter.incrementAndGet(), taskName, taskType, priority, scheduleType, fixedDate, taskEventHandler);
        tasks.put(task.getTaskId(), task);
        queue.add(task);
        return task;
    }

    public Task scheduleRecurring(String taskName, TaskType taskType, int priority, ScheduleType scheduleType, Date firstTime, long period, TaskEventHandler taskEventHandler) {
        Task task = new Task(counter.incrementAndGet(), taskName, taskType, priority, scheduleType, firstTime, period, taskEventHandler);
        tasks.put(task.getTaskId(), task);
        queue.add(task);
        return task;
    }

    public void changePriority(int taskId, int priority) {
        Task task = tasks.get(taskId);
        task.setPriority(priority);
        queue.changePriority(task);
    }

    public void cancel(int taskId) {
        Task task = tasks.get(taskId);
        tasks.remove(taskId);
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
