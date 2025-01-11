package com.shravan.learn.taskmanagementsystem;

import java.util.Date;

public class Task {
    private final String id;
    private String title;
    private String description;
    private Date dueDate;
    private int priority;
    private TaskStatus status;
    private final User assignedUser;

    public Task(String id, User assignedUser, TaskStatus status, int priority, Date dueDate, String description, String title) {
        this.id = id;
        this.assignedUser = assignedUser;
        this.status = status;
        this.priority = priority;
        this.dueDate = dueDate;
        this.description = description;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public User getAssignedUser() {
        return assignedUser;
    }
}
