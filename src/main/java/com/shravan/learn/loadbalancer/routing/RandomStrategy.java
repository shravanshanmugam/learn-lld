package com.shravan.learn.loadbalancer.routing;

import com.shravan.learn.loadbalancer.Request;
import com.shravan.learn.loadbalancer.Server;

import java.util.List;
import java.util.Random;

public class RandomStrategy implements RoutingStrategy {

    private static final Random random = new Random();
    @Override
    public Server getServer(List<Server> servers, Request request) {
        Server server = servers.get(random.nextInt(servers.size()));
        System.out.println("selecting by random server " + server);
        return server;
    }
}
