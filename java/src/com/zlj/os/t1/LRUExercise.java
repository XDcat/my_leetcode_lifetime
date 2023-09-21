package com.zlj.os.t1;

import java.util.HashMap;
import java.util.Map;

public class LRUExercise {
    public static void main(String[] args) {
        // ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
        // [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
        // res [null, null, null, 1, null, -1, null, -1, 3, 4]
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}

class LRUCache {
    private Map<Integer, Node> map;
    private int capacity;
    private Node head, tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (map.containsKey(key)){
            // put to head
            Node node = map.get(key);
            putToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            // update
            Node node = map.get(key);
            node.value = value;
            putToHead(node);
        } else {
            // delete
            if (map.size() == capacity){
                map.remove(deleteLast().key);
            }
            // add
            Node node = new Node();
            node.value = value;
            node.key = key;
            map.put(key, node);
            addAfterHead(node);
        }
    }

    private Node deleteLast() {
        return delete(tail.pre);
    }

    private void putToHead(Node node) {
        delete(node);
        addAfterHead(node);
    }

    private Node delete(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        return node;
    }

    private void addAfterHead(Node node){
        node.next = head.next;
        node.pre = head;
        
        node.pre.next = node;
        node.next.pre = node;
    }

}

class Node {
    Node next;
    Node pre;
    int value;
    int key;
}