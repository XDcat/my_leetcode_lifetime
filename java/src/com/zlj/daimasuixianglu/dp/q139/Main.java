package com.zlj.daimasuixianglu.dp.q139;

import java.util.Arrays;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "leetcode";
        List<String> wordDict = List.of("leet", "code");
        System.out.println(s.wordBreak(str, wordDict));
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int size = s.length();
        boolean[] dp = new boolean[size + 1];
        dp[0] = true;

        for (int j = 0; j <= size; j++){  // bag size
            for (int i = 0; i < wordDict.size(); i++){  // word
                String word = wordDict.get(i);
                if (j >= word.length() && dp[j - word.length()] && s.substring(j - word.length(), j).equals(word)){
                    dp[j] = true;
                }
            }
            // System.out.println(Arrays.toString(dp));
        }

        return dp[size];
    }
}