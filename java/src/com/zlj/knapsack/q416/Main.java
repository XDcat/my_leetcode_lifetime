package com.zlj.knapsack.q416;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,5,10,6};
        System.out.println(solution.canPartition(nums));
    }
}

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;
        // 01 knapsack, target sum / 2
        int n = sum / 2;

        int[][] dp = new int[nums.length + 1][n + 1];
        for (int[] row :
                dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = nums[i - 1]; j <= n; j++) {
                if (dp[i - 1][j - nums[i - 1]] >= 0){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
                }
            }
        }

        for (int[] row :
                dp) {
            System.out.println(Arrays.toString(row));
        }
        return dp[nums.length][n] == n;
    }
}
