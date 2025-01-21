package com.shravan.learn.loadbalancer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoadBalancer {
    private static LoadBalancer instance;
    private final Map<String, Service> services;

    private LoadBalancer() {
        services = new HashMap<>();
    }

    public static LoadBalancer getInstance() {
        if (instance == null) {
            instance = new LoadBalancer();
        }
        return instance;
    }

    public void addService(String name, String path) {
        Service service = new Service(name, path);
        services.put(service.getPath(), service);
    }

    public void addServer(String path, Server server) {
        services.get(path).getServers().add(server);
    }

    public void route(Request request) {
        String path = request.getPath();
        Service service = services.get(path);
        Server selected = service.getRoutingStrategy().getServer(service.getServers(), request);
        service.getClient().forward(selected, request);
    }
}
