package com.zlj.leetcode.offerjianzhi;

public class Q15CountOne {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
//        System.out.println(solution.hammingWeight(128));
//        System.out.println(solution.hammingWeight(31));
        System.out.println(solution.hammingWeight(-3));
    }

    public static class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0;
            while (n != 0){
                count += n & 1;
                n = n >>> 1;
            }
            return count;
        }
    }
    public static class Solution1 {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0;
            while (n != 0){
                n = n & (n - 1);
                count ++;
            }
            return count;
        }
    }
}
