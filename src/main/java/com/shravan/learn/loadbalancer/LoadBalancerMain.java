package com.shravan.learn.loadbalancer;

// Request distribution, Health monitoring Session persistence, Scalability, LB Algorithms,
// LB Algorithms - round-robin, weighted round-robin, least connections, least response time, source IP hashed, least resource utilization
// Fault tolerance, Monitoring and Logging

// LoadBalancer -> map Services (path -> Service)
// Service -> name, path, Servers, RoutingStrategy, Client (HTTP/TCP/gRPC)
// Server -> id, ip, healthy
// Request -> path, content
public class LoadBalancerMain {
    public static void main(String[] args) {
        LoadBalancer loadBalancer = LoadBalancer.getInstance();
        loadBalancer.addService("users", "/users");
        loadBalancer.addServer("/users", new Server("10.0.0.1"));
        loadBalancer.addServer("/users", new Server("10.0.0.2"));
        loadBalancer.addServer("/users", new Server("10.0.0.3"));

        loadBalancer.route(new Request("/users", "content1"));
        loadBalancer.route(new Request("/users", "content2"));
        loadBalancer.route(new Request("/users", "content3"));
        loadBalancer.route(new Request("/users", "content4"));
    }
}
