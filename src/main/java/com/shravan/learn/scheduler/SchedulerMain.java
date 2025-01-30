package com.shravan.learn.scheduler;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class SchedulerMain
{
    // schedule task
    // task type - insert, read, delete
    // change priority
    // change parallelism
    // cancel task
    // schedule with cron expression, fixed date, interval repeat
    // graceful handling of task failure

    // API to reschedule, change priority, change parallelism, completion events
    public static void main( String[] args ) throws InterruptedException {
        TaskScheduler taskScheduler = new TaskScheduler(2);
        Date now = new Date();
        long next = now.getTime() + 5 * 1000;
        Date fixedDate = new Date(next);
        taskScheduler.scheduleFixedDate("task1", TaskType.READ, 1, ScheduleType.FIXED_DATE, fixedDate, new TaskEventHandler() {
            @Override
            public void onStart() {
                System.out.println("started task1");
            }

            @Override
            public void onEnd() {
                System.out.println("ended task1");
            }
        });
        Task task2 = taskScheduler.scheduleRecurring("task2", TaskType.READ, 10, ScheduleType.RECURRING, now, 2000, new TaskEventHandler() {
            @Override
            public void onStart() {
                System.out.println("started task2");
            }

            @Override
            public void onEnd() {
                System.out.println("ended task2");
            }
        });
        Task task3 = taskScheduler.scheduleRecurring("task3", TaskType.READ, 5, ScheduleType.RECURRING, now, 2000, new TaskEventHandler() {
            @Override
            public void onStart() {
                System.out.println("started task3");
            }

            @Override
            public void onEnd() {
                System.out.println("ended task3");
            }
        });
        Thread.sleep(5000);
        System.out.println("changing priority of task2");
        taskScheduler.changePriority(task2.getTaskId(), 1);
        Thread.sleep(5000);
        System.out.println("cancel task2");
        taskScheduler.cancel(task2.getTaskId());
        Thread.sleep(5000);
        System.out.println("change parallelism");
        taskScheduler.changeParallelism(1);
    }
}
