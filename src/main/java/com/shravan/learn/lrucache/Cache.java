package com.shravan.learn.lrucache;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    List list;
    Map<Integer, Node> map;
    int capacity;
    int size;

    Cache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        list = new List();
        size = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
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
        } else {
            if (size == capacity) {
                Node removed = list.removeHead();
                map.remove(removed.key);
            } else {
                size++;
            }
            Node node = new Node(key, value);
            map.put(key, node);
            list.addLast(node);
        }
        list.print();
    }
}
