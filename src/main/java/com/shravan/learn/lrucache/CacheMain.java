package com.shravan.learn.lrucache;

// Cache -> Map Nodes, List
// List -> head Node, tail Node
// Node -> prev, next, key, value
public class CacheMain {

    public static void main(String[] args) {
        Cache cache = new Cache(3);

        cache.set(1, 10);
        cache.set(2, 20);
        cache.set(3, 30);;

        System.out.println("cache.get(1) = " + cache.get(1));
        System.out.println("cache.get(2) = " + cache.get(2));

        cache.set(4, 40);

        System.out.println("cache.get(3) = " + cache.get(3));
        System.out.println("cache.get(4) = " + cache.get(4));

        cache.set(2, 200);

        System.out.println("cache.get(1) = " + cache.get(1));
        System.out.println("cache.get(2) = " + cache.get(2));
    }
}
