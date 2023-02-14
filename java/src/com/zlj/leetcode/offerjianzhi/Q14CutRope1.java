package com.zlj.leetcode.offerjianzhi;

public class Q14CutRope1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.cuttingRope(2));
        System.out.println(solution.cuttingRope(10));
    }
    static class Solution {
        public int cuttingRope(int n) {
            int[] dp = new int[n];
            dp[0] = 0;
            // dp 0->n-1
            for (int i = 1; i < n ; i++) {
                int max = i;
                for (int j = 0; j <= (i / 2) ; j++) {
                    int n1 = j;
                    int n2 = i - j;
                    int value = dp[n1] * dp[n2];
                    max = Math.max(max, value);
                }
                dp[i] = max;
            }

            int res = -1;
            for (int j = 1; j <= (n / 2) ; j++) {
                int n1 = j;
                int n2 = n - j;
                int value = dp[n1] * dp[n2];
                res = Math.max(res, value);
            }
            return res;
        }
    }
}
