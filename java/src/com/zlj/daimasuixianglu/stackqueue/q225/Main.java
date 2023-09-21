package com.zlj.daimasuixianglu.stackqueue.q225;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Lianjie Zeng <zenglianjie@foxmail.com>
 * Created on 2023-07-30
 */
public class Main {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
        HashMap<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
    }
}


class MyStack {
    private Queue<Integer> q1, q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.offer(x);
    }

    public int pop() {
        while (q1.size() > 1){
            q2.offer(q1.poll());
        }

        int res = q1.poll();
        Queue<Integer> t = q1;
        q1 = q2;
        q2 = t;

        return res;
    }

    public int top() {
        int res = pop();
        push(res);
        return res;
    }

    public boolean empty() {
        return q1.size() + q2.size() == 0;
    }
}