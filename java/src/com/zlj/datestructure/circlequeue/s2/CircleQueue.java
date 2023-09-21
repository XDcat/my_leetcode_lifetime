package com.zlj.datestructure.circlequeue.s2;

/**
 * @author Lianjie Zeng <zenglianjie@foxmail.com>
 * Created on 2023-08-09
 */
public class CircleQueue {
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);

    }
}


class MyCircularQueue {
    private int[] queue;
    private int head;
    private int tail;
    private int capacity;

    public MyCircularQueue(int k) {
        capacity = k + 1;
        queue = new int[capacity];
        head = tail = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        queue[tail] = value;
        tail = (tail + 1) % capacity;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        head = (head + 1) % capacity;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return queue[head];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return queue[(tail - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return (tail + 1) % capacity == head;
    }
}