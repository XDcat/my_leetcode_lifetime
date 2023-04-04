package com.zlj.os.exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LRU {
    public static void main(String[] args) {
        int[] nums = new int[]{7, 0, 1, 2, 0, 3, 0, 4};
        LRU lru = new LRU(4);
        for (int i :
                nums) {
            lru.put(i, i);
            System.out.println(lru);
        }
    }

    private Map<Integer, Node> map;
    private Node vhead;
    private Node vtail;
    private int captical, size;

    public LRU(int captical) {
        this.captical = captical;
        map = new HashMap<>();
        vhead = new Node(-1);
        vtail = new Node(-1);
        vhead.next = vtail;
        vtail.pre = vhead;
    }

    public void put(int k, int v) {
        Node node = map.get(k);
        if (node == null) {
            // not exits -> add to head
            node = new Node(v);
            map.put(k, node);
            addToHead(node);
            size++;
            if (size > captical) {
                deleteTail();
                map.remove(k);
                size--;
            }
        } else {
            node.value = v;
            moveToHead(node);
        }
    }

    private void moveToHead(Node node) {
        deleteNode(node);
        addToHead(node);
    }

    private void addToHead(Node node) {
        node.pre = vhead;
        node.next = vhead.next;
        vhead.next = node;
        node.next.pre = node;
    }

    private void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void deleteTail() {
        Node node = vtail.pre;
        vtail.pre = node.pre;
        node.pre = node.next;
    }

    @Override
    public String toString() {
        int[] nums = new int[size];
        Node cur = vhead.next;
        for (int i = 0; i < size; i++) {
            nums[i] = cur.value;
            cur = cur.next;
        }
        return "LRU: " + Arrays.toString(nums);
    }
}

class Node {
    int value;
    Node pre;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}
