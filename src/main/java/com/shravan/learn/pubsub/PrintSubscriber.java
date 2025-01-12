package com.shravan.learn.pubsub;

public class PrintSubscriber implements Subscriber {
    private final String name;

    public PrintSubscriber(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void onMessage(Message message) {
        System.out.println(name + " received " + message.getContent());
    }
}
