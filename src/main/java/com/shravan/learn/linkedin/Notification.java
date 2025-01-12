package com.shravan.learn.linkedin;

import java.util.Objects;
import java.util.UUID;

public class Notification {
    private final String id;
    private final User receiver;
    private final NotificationType type;
    private final String content;
    private final long timestamp;

    public Notification(User receiver, NotificationType type, String content) {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.receiver = receiver;
        this.type = type;
        this.content = content;
        this.timestamp = System.currentTimeMillis();
    }

    public String getId() {
        return id;
    }

    public User getReceiver() {
        return receiver;
    }

    public NotificationType getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Notification)) return false;
        Notification that = (Notification) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
