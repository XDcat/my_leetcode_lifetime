package com.zlj.leetcode.offerjianzhi;

public class Q17PrintToN {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.printNumbers(3));
    }
    static class Solution2 {
        char[] nums = "0123456789".toCharArray();
        int left, nine;
        StringBuilder res;
        public String printNumbers(int n) {
            res = new StringBuilder();
            left = n - 1;
            nine = 0;
            char[] pre = new char[n];
            dfs(pre, n, 0);
            return res.toString();
        }
        private void dfs(char[] pre, int n, int i){
            if (i == n){
                String s = String.valueOf(pre).substring(left);
                if (s.equals("0")){
                    return;
                }
                if (n - left == nine){
                    left --;
                }
                res.append( s + ",");
                return;
            }

            for (char c: nums){
                if (c == '9'){
                    nine ++;
                }
                pre[i] = c;
                dfs(pre, n, i + 1);
            }
            nine --;
        }
    }
}
