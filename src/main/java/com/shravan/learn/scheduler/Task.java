package com.shravan.learn.scheduler;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Task {
    private final int taskId;
    private final String taskName;
    private final TaskType taskType;
    private final long submittedAt;
    private final ScheduleType scheduleType;
    private Date fixedDate;
    private Date firstTime;
    private long period;
    private long nextExecutionTime;
    private boolean done;
    private int priority;
    private TaskEventHandler taskEventHandler;

    public Task(int taskId, String taskName, TaskType taskType, int priority, ScheduleType scheduleType, Date fixedDate, TaskEventHandler taskEventHandler) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskType = taskType;
        submittedAt = System.currentTimeMillis();
        this.priority = priority;
        this.scheduleType = scheduleType;
        this.fixedDate = fixedDate;
        nextExecutionTime = fixedDate.getTime();
        done = false;
        this.taskEventHandler = taskEventHandler;
    }

    public Task(int taskId, String taskName, TaskType taskType, int priority, ScheduleType scheduleType, Date firstTime, long period, TaskEventHandler taskEventHandler) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskType = taskType;
        submittedAt = System.currentTimeMillis();
        this.priority = priority;
        this.scheduleType = scheduleType;
        this.firstTime = firstTime;
        this.period = period;
        nextExecutionTime = firstTime.getTime();
        done = false;
        this.taskEventHandler = taskEventHandler;
    }

    public void setDone() {
        this.done = true;
    }


    @Override
    public String toString() {
        return "{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", priority=" + priority +
                '}';
    }
}
