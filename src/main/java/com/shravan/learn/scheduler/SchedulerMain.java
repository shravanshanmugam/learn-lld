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
        TaskScheduler taskScheduler = new TaskScheduler(3);
        Date now = new Date();
        EventHandler eventHandler = new EventHandler() {
            @Override
            public void onStart() {
//                System.out.println("started");
            }

            @Override
            public void onEnd() {
//                System.out.println("ended");
            }
        };
        ScheduledTask task1 = taskScheduler.schedule(new OneTimeTask(1,  eventHandler, now.getTime()));
        ScheduledTask task2 = taskScheduler.schedule(new RecurringTask(10, eventHandler, now.getTime(), 2000));
        ScheduledTask task3 = taskScheduler.schedule(new RecurringTask(5, eventHandler, now.getTime(), 2000));
        Thread.sleep(5000);
        System.out.println("changing priority of task2");
        taskScheduler.changePriority(task2, 1);
        Thread.sleep(5000);
        System.out.println("cancel task2");
        taskScheduler.cancel(task2);
        Thread.sleep(5000);
        System.out.println("change parallelism");
        taskScheduler.changeParallelism(1);
    }
}
