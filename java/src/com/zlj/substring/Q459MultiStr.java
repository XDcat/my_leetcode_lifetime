package com.zlj.substring;

public class Q459MultiStr {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.repeatedSubstringPattern("abac"));
    }
    static class Solution {
        public boolean repeatedSubstringPattern(String s) {
            // get next
            int[] next = new int[s.length()];
            next[0] = 0;
            int j = 0;
            for (int i = 1; i < s.length(); i++) {
                while (j > 0 && s.charAt(i) != s.charAt(j)){
                    j = next[ j - 1];
                }

                if (s.charAt(i) == s.charAt(j)){
                    j ++;
                }
                next[i] = j;
            }

            return next[next.length - 1] > 0 && s.length() % (s.length() - next[next.length - 1]) == 0;
        }
    }
}
