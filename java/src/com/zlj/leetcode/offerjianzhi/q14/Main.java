package com.zlj.leetcode.offerjianzhi.q14;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.cuttingRope(10));
    }
}

class Solution {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            int max=i;
            for (int j = 1; j <= i / 2; j++) {
                max = Math.max(max, dp[j] * dp[i - j]);
            }
            dp[i] = max;
        }

        int res = 1;
        for (int i = 1; i < n - 1; i++) {
            res = Math.max(res, dp[i] * dp[n - i]);
        }

        return res;
    }
}
