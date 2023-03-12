package com.zlj.leetcode.offerjianzhi.q31;

import java.util.Deque;
import java.util.LinkedList;

public class ValidStackSequences {

}
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int p = 0;
        for (int i: pushed){
            stack.push(i);
            while (!stack.isEmpty() && stack.peek() == popped[p]){
                stack.pop();
                p++;
            }
        }
        return stack.isEmpty();
    }
}
