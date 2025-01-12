package com.shravan.learn.pubsub;

public interface Subscriber {
    void onMessage(Message message);
}
