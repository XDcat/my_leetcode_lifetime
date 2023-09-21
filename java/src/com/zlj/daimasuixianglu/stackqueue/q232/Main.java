package com.zlj.daimasuixianglu.stackqueue.q232;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Lianjie Zeng <zenglianjie@foxmail.com>
 * Created on 2023-07-30
 */
public class Main {
}

class MyQueue {
    private Deque<Integer> in, out;

    public MyQueue() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if (out.size() == 0){
            while (in.size() > 0){
                out.push(in.pop());
            }
        }

        return out.pop();
    }

    public int peek() {
        if (out.size() == 0){
            while (in.size() > 0){
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    public boolean empty() {
        return in.size() + out.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
