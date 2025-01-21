package com.shravan.learn.loadbalancer.routing;

import com.shravan.learn.loadbalancer.Request;
import com.shravan.learn.loadbalancer.Server;

import java.util.List;

public interface RoutingStrategy {
    Server getServer(List<Server> servers, Request request);
}
