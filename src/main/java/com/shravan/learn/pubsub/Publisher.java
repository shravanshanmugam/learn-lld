package com.shravan.learn.pubsub;

import java.util.HashSet;
import java.util.Set;

public class Publisher {
    private final String name;
    private Set<Topic> topics;

    public Publisher(String name) {
        this.name = name;
        topics = new HashSet<>();
    }

    public void registerTopic(Topic topic) {
        topics.add(topic);
    }

    public void publish(Topic topic, Message message) {
        if (!topics.contains(topic)) {
            System.out.println(name + "can't publish to " + topic.getName());
            return;
        }
        topic.send(message);
    }
}
