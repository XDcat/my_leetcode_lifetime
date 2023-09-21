package com.zlj.daimasuixianglu.dp.q188;

public class Main {
    
}

        
class Solution {
    public int maxProfit(int k, int[] prices) {
        // no -> keep1 -> no1 -> keep2 -> no2 -> ...
        int[][] dp = new int[prices.length][1 + 2 * k];

        // init dp[0][...]
        for (int i = 0; i < k; i++){
            dp[0][2 * i + 1] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++){
            for (int j = 0; j < k; j++){
                dp[i][2 * j + 1] = Math.max(dp[i - 1][2 * j + 1], dp[i - 1][2 * j] - prices[i]);
                dp[i][2 * j + 2] = Math.max(dp[i - 1][2 * j + 2], dp[i - 1][2 * j + 1] + prices[i]);
            }
        }

        // find res
        int res = 0;
        for (int i = 0; i < dp[0].length; i++){
            res = Math.max(res, dp[prices.length - 1][i]);
        }

        return res;
    }
}