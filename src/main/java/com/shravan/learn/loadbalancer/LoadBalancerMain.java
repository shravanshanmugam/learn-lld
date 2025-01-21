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

        loadBalancer.addService("transactions", "/transactions");
        loadBalancer.addServer("/transactions", new Server("10.0.1.1"));
        loadBalancer.addServer("/transactions", new Server("10.0.1.2"));
        loadBalancer.addServer("/transactions", new Server("10.0.1.3"));
        loadBalancer.addServer("/transactions", new Server("10.0.1.4"));
        loadBalancer.addServer("/transactions", new Server("10.0.1.5"));


        loadBalancer.route(new Request("/users", "user content1"));
        loadBalancer.route(new Request("/transactions", "transaction content1"));
        loadBalancer.route(new Request("/transactions", "transaction content2"));
        loadBalancer.route(new Request("/transactions", "transaction content7"));
        loadBalancer.route(new Request("/users", "user content2"));
        loadBalancer.route(new Request("/transactions", "transaction content8"));
        loadBalancer.route(new Request("/users", "user content3"));
        loadBalancer.route(new Request("/transactions", "transaction content3"));
        loadBalancer.route(new Request("/transactions", "transaction content4"));
        loadBalancer.route(new Request("/users", "user content4"));
        loadBalancer.route(new Request("/users", "user content5"));
        loadBalancer.route(new Request("/transactions", "transaction content5"));
        loadBalancer.route(new Request("/transactions", "transaction content6"));

    }
}
