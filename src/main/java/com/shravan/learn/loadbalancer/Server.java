package com.shravan.learn.loadbalancer;


import lombok.Getter;
import lombok.Setter;

@Getter
public class Server {
    private final String ip;
    @Setter
    private boolean healthy;

    public Server(String ip) {
        this.ip = ip;
        healthy = true;
    }

    @Override
    public String toString() {
        return "Server{" +
                "ip='" + ip + '\'' +
                ", healthy=" + healthy +
                '}';
    }
}
