package com.shravan.learn.loadbalancer.routing;

import com.shravan.learn.loadbalancer.Request;
import com.shravan.learn.loadbalancer.Server;

import java.util.List;

public class RoundRobinStrategy implements RoutingStrategy {
    private int currentIndex;
    public RoundRobinStrategy() {
        currentIndex = 0;
    }
    @Override
    public Server getServer(List<Server> servers, Request request) {
        Server server = servers.get(currentIndex);
        currentIndex = (currentIndex + 1) % servers.size();
//        System.out.println("selecting by round robin server " + server);
        return server;
    }
}
