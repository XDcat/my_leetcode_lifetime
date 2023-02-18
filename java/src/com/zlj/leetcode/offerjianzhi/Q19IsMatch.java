package com.zlj.leetcode.offerjianzhi;

import java.util.Arrays;

public class Q19IsMatch {
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.isMatch("ab", ".*"));
        System.out.println(s.isMatch("aab", "c*a*b"));
        System.out.println(s.isMatch("aaa", "ab*a*c*a"));
    }
    static class Solution {
        public boolean isMatch(String s, String p) {
            int n = s.length();
            int m = p.length();

            s = " " + s;
            p = " " + p;
            // init dp array
            boolean[][] dp = new boolean[n + 1][m + 1];
            dp[0][0] = true;
            System.out.println(Arrays.deepToString(dp));

            // dp start
            for (int i = 0; i < n + 1; i++) {
                for (int j = 1; j < m + 1; j++) {
                    System.out.println("" + i + " " + j);

                    if (p.charAt(j) != '*'){
                        if (i > 0 && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.')){
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    } else {
                        if (i > 0 && (s.charAt(i) == p.charAt(j-1) || p.charAt(j - 1) == '.')){
                            // valid *
                            dp[i][j] |= dp[i-1][j];
                        }
                        if (j > 1){
                            // invalid *
                            dp[i][j] |= dp[i][j - 2];
                        }
                    }
                }
            }
            System.out.println(Arrays.deepToString(dp));
            return dp[n][m];
        }
    }
}

