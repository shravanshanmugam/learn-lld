package com.shravan.learn.lrucache;

public class List {
    Node head;
    Node tail;

    List() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    void delete(Node n) {
        Node prev = n.prev;
        Node next = n.next;
        prev.next = next;
        next.prev = prev;
    }

    void addLast(Node n) {
        Node last = tail.prev;
        last.next = n;
        n.prev = last;
        n.next = tail;
        tail.prev = n;
    }

    Node removeHead() {
        Node next = head.next;
        delete(next);
        return next;
    }

    void access(Node n) {
        delete(n);
        addLast(n);
    }

    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.key +"=" + temp.value + "->");
            temp = temp.next;
        }
        System.out.println();
    }
}
