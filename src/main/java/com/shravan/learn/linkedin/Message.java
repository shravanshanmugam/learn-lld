package com.shravan.learn.linkedin;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Message {
    private final String id;
    private final User sender;
    private final User receiver;
    private final String content;
    private final long timestamp;

    public Message(User sender, User receiver, String content) {
        this.id = generateId();
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.timestamp = new Date().getTime();
    }

    private String generateId() {
        return UUID.randomUUID().toString().substring(0,8);
    }

    public String getId() {
        return id;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public String getContent() {
        return content;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return Objects.equals(id, message.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
