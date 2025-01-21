package com.shravan.learn.loadbalancer;

import com.shravan.learn.loadbalancer.client.Client;
import com.shravan.learn.loadbalancer.client.HttpClient;
import com.shravan.learn.loadbalancer.routing.RandomStrategy;
import com.shravan.learn.loadbalancer.routing.RoutingStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Service {
    private final String name;
    private final String path;
    private List<Server> servers;
    @Setter
    private RoutingStrategy routingStrategy;
    @Setter
    private Client client;

    public Service(String name, String path) {
        this.name = name;
        this.path = path;
        this.servers = new ArrayList<>();
        routingStrategy = new RandomStrategy();
        client = new HttpClient();
    }
}
