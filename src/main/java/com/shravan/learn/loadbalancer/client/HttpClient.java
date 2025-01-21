package com.shravan.learn.loadbalancer.client;

import com.shravan.learn.loadbalancer.Request;
import com.shravan.learn.loadbalancer.Server;

public class HttpClient implements Client {

    @Override
    public void forward(Server server, Request request) {
        System.out.println("forwarding request " + request + " from " + getName() + " client to " + server);
    }

    @Override
    public String getName() {
        return "HTTP";
    }


}
