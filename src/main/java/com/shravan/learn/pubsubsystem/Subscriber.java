package com.shravan.learn.pubsubsystem;

public interface Subscriber {
    void onMessage(Message message);
}
