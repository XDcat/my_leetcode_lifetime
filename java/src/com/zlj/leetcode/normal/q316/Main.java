package com.zlj.leetcode.normal.q316;

import java.util.Deque;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.removeKdigits("987654321", 3);
        System.out.println(res);
    }
}

class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Integer> stack = new LinkedList<>();
        int remain = num.length() - k;

        for (char c: num.toCharArray()){
            int n = c - '0';

            while (k > 0 && stack.size() > 0 && stack.peek() > n){
                k--;
                stack.pop();
            }
            stack.push(n);
        }

        

        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0){
            sb.append(stack.pollLast());
        }

        String res =  sb.toString();
        return res;
    }
}