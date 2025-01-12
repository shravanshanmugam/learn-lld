package com.shravan.learn.linkedin;

import java.util.*;

public class User {
    private final String id;
    private final String name;
    private final String email;
    private final String pwd;
    private final Profile profile;
    private final Set<Connection> connections;
    private final List<Message> inbox;
    private final List<Message> sent;

    public User(String name, String email, String pwd) {
        this.id = generateId();
        this.name = name;
        this.email = email;
        this.pwd = pwd;
        profile = new Profile(this);
        connections = new HashSet<>();
        inbox = new ArrayList<>();
        sent = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPwd() {
        return pwd;
    }

    public Profile getProfile() {
        return profile;
    }

    public Set<Connection> getConnections() {
        return connections;
    }

    public List<Message> getInbox() {
        return inbox;
    }

    public List<Message> getSent() {
        return sent;
    }

    private String generateId() {
        return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
