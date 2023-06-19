package com.zlj.knapsack;

public class q01 {

}

class Solution{
    /**
     * 01 knapsack
     * @param v value
     * @param w weight
     * @param n the space of package
     * @return max value for the package
     */
    public int solve(int[] v, int[] w, int n){
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = w[i - 1]; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
            }
        }
        return dp[n][n];
    }
}