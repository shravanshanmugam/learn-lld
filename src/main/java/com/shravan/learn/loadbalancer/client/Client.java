package com.shravan.learn.loadbalancer.client;

import com.shravan.learn.loadbalancer.Request;
import com.shravan.learn.loadbalancer.Server;

public interface Client {
    void forward(Server server, Request Request);
    String getName();
}
