package com.shravan.learn.lrucache;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    List list;
    Map<Integer, Node> map;
    int capacity;

    Cache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        list = new List();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            // move to tail on get
            list.access(node);
            list.print();
            return node.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            // move to tail on set
            list.access(node);
        } else {
            // check size
            if (map.size() == capacity) {
                // return removed node from list
                Node removed = list.removeHead();
                // remove from map also
                map.remove(removed.key);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            list.addLast(node);
        }
        list.print();
    }
}
