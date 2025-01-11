package com.shravan.learn.taskmanagementsystem;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskManager {
    private static TaskManager instance = new TaskManager();

    private Map<String, Task> tasks;
    private Map<String, List<Task>> userTasks;
    private TaskManager() {
        tasks = new HashMap<>();
        userTasks = new HashMap<>();
    }

    public static TaskManager getInstance() {
        return instance;
    }

    public void createTask(Task task) {
        tasks.put(task.getId(), task);
        assign(task.getAssignedUser(), task);
    }

    public void updateTask(Task updatedTask) {
        Task existingTask = tasks.get(updatedTask.getId());
        if (existingTask != null) {
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setDueDate(updatedTask.getDueDate());
            existingTask.setPriority(updatedTask.getPriority());
            existingTask.setStatus(updatedTask.getStatus());
            User previousUser = existingTask.getAssignedUser();
            User newUser = updatedTask.getAssignedUser();
            if (!previousUser.equals(newUser)) {
                unassign(previousUser, existingTask);
                assign(newUser, existingTask);
            }
        }
    }

    public void deleteTask(String taskId) {
        Task task = tasks.remove(taskId);
        if (task != null) {
            unassign(task.getAssignedUser(), task);
        }
    }

    public List<Task> searchTasks(String keyword) {
        List<Task> matchingTasks = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task.getTitle().contains(keyword) || task.getDescription().contains(keyword)) {
                matchingTasks.add(task);
            }
        }
        return matchingTasks;
    }

    public List<Task> filterTasks(TaskStatus status, Date startDate, Date endDate, int priority) {
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task.getStatus() == status &&
                    task.getDueDate().compareTo(startDate) >= 0 &&
                    task.getDueDate().compareTo(endDate) <= 0 &&
                    task.getPriority() == priority) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }

    public void markAsCompleted(String taskId) {
        Task task = tasks.get(taskId);
        if (task != null) {
            task.setStatus(TaskStatus.COMPLETED);
        }
    }

    private List<Task> getTaskHistory(User user) {
        return new ArrayList<>(userTasks.getOrDefault(user.getId(), new ArrayList<>()));
    }

    private void unassign(User user, Task task) {
        List<Task> t = this.userTasks.get(user.getId());
        if (t != null) {
            t.remove(task);
        }
    }

    private void assign(User user, Task task) {
        userTasks.computeIfAbsent(user.getId(), k -> new CopyOnWriteArrayList<>()).add(task);
    }
}
