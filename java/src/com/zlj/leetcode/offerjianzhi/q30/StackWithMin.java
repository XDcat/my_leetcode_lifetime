package com.zlj.leetcode.offerjianzhi.q30;

import java.util.Deque;
import java.util.LinkedList;

public class StackWithMin {
}

class MinStack {
    Deque<Integer> A, B;  // main, aux
    /** initialize your data structure here. */
    public MinStack() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    public void push(int x) {
        A.push(x);
        if (B.size() == 0 || x < B.peek()){
            B.push(x);
        }
    }

    public void pop() {
        int popVal = A.pop();
        if (popVal == B.peek()){
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
