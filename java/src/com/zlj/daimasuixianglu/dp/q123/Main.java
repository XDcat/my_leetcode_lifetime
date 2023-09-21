package com.zlj.daimasuixianglu.dp.q123;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(prices));
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        // no keep -> keep1 -> no keep1 -> keep2 -> no keep2
        // dp[0][...][...] 和 dp[...][0][...] 只用于统一循环
        int k = 2;
        int[][][] dp = new int[k + 1][prices.length + 1][2];

        for (int i = 1; i <= prices.length; i++){
            int price = prices[i - 1];
            for (int j = 1; j <= k; j++){
                // 持有 dp[j][i][0]
                if (i >= j){
                    if (i == j){
                        dp[j][i][0] = dp[j - 1][i - 1][1] - price;
                    } else {
                        dp[j][i][0] = Math.max(dp[j][i - 1][0], dp[j - 1][i - 1][1] - price);
                    }
                }

                // 无持有 dp[j][i][1]
                if (i - 1 >= j){
                    if (i - 1 == j){
                        dp[j][i][1] = dp[j][i - 1][0] + price;
                    } else {
                        dp[j][i][1] = Math.max(dp[j][i - 1][1], dp[j][i - 1][0] + price);
                    }
                }
            }
        }

        // output
        for (int j = 1; j <= k; j++){
            System.out.println("------" + j + "------");
            for (int[] row: dp[j]){
                System.out.println(Arrays.toString(row));
            }
        }

        // result
        int res = 0;
        for (int j = 1; j <= k ; j++){
            res = Math.max(res, dp[j][prices.length][0]);
            res = Math.max(res, dp[j][prices.length][1]);
        }

        return res;
    }
}
