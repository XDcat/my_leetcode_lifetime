package com.zlj.datestructure.circlequeue;

/**
 * @author Lianjie Zeng <zenglianjie@foxmail.com>
 * Created on 2023-08-09
 */
public class LoopQueue {
}



class MyCircularQueue {
    private int[] queue;
    private int head;
    private int tail;
    private int size;

    public MyCircularQueue(int k) {
        size = k;
        queue = new int[k];

    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        queue[tail % size] = value;
        tail++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        head++;
        return true;
    }

    public int Front() {
        return isEmpty()? -1 : queue[head % size];
    }

    public int Rear() {
        return isEmpty()? -1: queue[(tail - 1) % size];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return tail - head == size;
    }
}