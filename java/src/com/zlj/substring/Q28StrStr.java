package com.zlj.substring;

public class Q28StrStr {
    public static void main(String[] args) {
        Solution2 s1 = new Solution2();
        System.out.println(s1.strStr("sadbutsad", "sad"));
        System.out.println(s1.strStr("a", "a"));
        System.out.println(s1.strStr("leetcode", "leeto"));

    }
    static class Solution1 {
        public int strStr(String haystack, String needle) {
            int n = haystack.length();
            int m = needle.length();
            int j;
            for (int i = 0; i <= n - m; i++) {
                for (j = 0; j < m; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)){
                        break;
                    }
                }
                if (j == m){
                    return i;
                }
            }
            return -1;
        }
    }
    static class Solution2 {
        public int strStr(String haystack, String needle) {
            int n = haystack.length();
            int m = needle.length();
            int i = 0, j = 0;
            while (i < n && j < m){
                if (haystack.charAt(i) == needle.charAt(j)){
                    i ++;
                    j ++;
                } else {
                    i = i - j + 1;
                    j = 0;
                }
            }
            if (j == m){
                return i - j;
            } else {
                return -1;
            }
        }
    }
    static class Solution3 {
        public int strStr(String haystack, String needle) {
            int n = haystack.length();
            int m = needle.length();
            int i = 0, j = 0;
            int[] next = getNext(needle);
            while (i < n && j < m){
                while (j > 0 && haystack.charAt(i) != needle.charAt(j)){
                    j = next[j - 1];
                }
                if (haystack.charAt(i) == needle.charAt(j)){
                    j ++;
                }
                i += 1;
            }
            if (j == m){
                return i - j;
            } else {
                return -1;
            }
        }
        private int[] getNext(String s){
            int[] next = new int[s.length()];
            next[0] = 0;
            int j = 0;
            // i is the end of pre
            // j is the end of last
            for (int i = 1; i < s.length(); i++) {
                while (j > 0 && s.charAt(i) != s.charAt(j)){
                    j = next[j - 1];
                }

                if (s.charAt(i) == s.charAt(j)){
                    j += 1;
                }
                next[i] = j;
            }

            return next;
        }
    }
}
