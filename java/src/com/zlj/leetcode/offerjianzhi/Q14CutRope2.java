package com.zlj.leetcode.offerjianzhi;
import java.math.BigInteger;

public class Q14CutRope2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.cuttingRope(2));
        System.out.println(solution.cuttingRope(10));
        System.out.println(solution.cuttingRope(120));
    }
    static class Solution {
        public int cuttingRope(int n) {
            BigInteger[] dp = new BigInteger[n];
            dp[0] = BigInteger.valueOf(0);
            // dp 0->n-1
            for (int i = 1; i < n ; i++) {
                BigInteger max = BigInteger.valueOf(i);
                for (int j = 0; j <= (i / 2) ; j++) {
                    int n1 = j;
                    int n2 = i - j;
                    BigInteger value = BigInteger.valueOf(n1).multiply(BigInteger.valueOf(n2));
                    max = max.max(value);
                }
                dp[i] = max;
            }

            BigInteger res = BigInteger.valueOf(-1);
            for (int j = 1; j <= (n / 2) ; j++) {
                int n1 = j;
                int n2 = n - j;
                BigInteger value = BigInteger.valueOf(n1).multiply(BigInteger.valueOf(n2));
                res = res.max(value);
            }
            return res.mod(BigInteger.valueOf(1000000007)).intValue();
        }
    }
}
