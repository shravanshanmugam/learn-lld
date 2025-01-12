package com.shravan.learn.linkedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class LinkedInService {
    private final Map<String, User> users;
    private final Map<String, List<Notification>> notifications;
    private final Map<String, JobPosting> jobPostings;

    public LinkedInService() {
        jobPostings = new HashMap<>();
        users = new HashMap<>();
        notifications = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public User login(String email, String pwd) {
        for (User user : users.values()) {
            if (user.getEmail().equals(email) && user.getPwd().equals(pwd)) {
                return user;
            }
        }
        return null;
    }

    public List<User> searchUsers(String keyword) {
        List<User> results = new ArrayList<>();
        for (User user : users.values()) {
            if (user.getName().contains(keyword)) {
                results.add(user);
            }
        }
        return results;
    }

    public void updateProfile(User user) {
        users.put(user.getId(), user);
    }

    public void sendConnectionRequest(User sender, User receiver) {
        Connection connection = new Connection(sender, System.currentTimeMillis());
        receiver.getConnections().add(connection);
        Notification notification = new Notification(receiver, NotificationType.CONNECTION_REQUEST, "New connection request from " + sender.getName());
        addNotification(receiver.getId(), notification);
    }

    public void acceptConnectionRequest(User user, User connectionUser) {
        user.getConnections().add(new Connection(connectionUser, System.currentTimeMillis()));
    }

    public void sendMessage(User sender, User receiver, String content) {
        Message message = new Message(sender, receiver, content);
        receiver.getInbox().add(message);
        sender.getSent().add(message);
        Notification notification = new Notification(receiver, NotificationType.MESSAGE, "New message from " + sender.getName());
        addNotification(receiver.getId(), notification);
    }

    public void postJobPosting(JobPosting jobPosting) {
        jobPostings.put(jobPosting.getId(), jobPosting);
        for (User user : users.values()) {
            Notification notification = new Notification(user, NotificationType.JOB_POSTING, "New job posting : " + jobPosting.getTitle());
            addNotification(user.getId(), notification);
        }
    }

    public List<JobPosting> searchJobs(String keyword) {
        List<JobPosting> results = new ArrayList<>();
        for (JobPosting jobPosting : jobPostings.values()) {
            if (jobPosting.getTitle().contains(keyword) || jobPosting.getDescription().contains(keyword)) {
                results.add(jobPosting);
            }
        }
        return results;
    }

    private void addNotification(String receiverId, Notification notification) {
        notifications.computeIfAbsent(receiverId, key -> new CopyOnWriteArrayList<>()).add(notification);
    }

    public List<Notification> getNotifications(String userId) {
        return notifications.getOrDefault(userId, new ArrayList<>());
    }
}
