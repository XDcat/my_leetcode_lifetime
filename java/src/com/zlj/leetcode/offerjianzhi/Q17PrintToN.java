package com.zlj.leetcode.offerjianzhi;

public class Q17PrintToN {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.printNumbers(3));
    }
    class Solution1 {
        public int[] printNumbers(int n) {
            int max_value = (int) (Math.pow(10, n) - 1);
            int[] res = new int[max_value];
            for (int i = 1; i < max_value + 1; i++) {
                res[i] = i;
            }
            return res;
        }
    }

    static class Solution2 {
        char[] nums = "0123456789".toCharArray();
        StringBuilder res;
        int left, nine;
        public String printNumbers(int n) {
            res = new StringBuilder();
            char[] pre = new char[n];
            left = n - 1;
            nine = 0;
            dfs(pre, n, 0);
            return res.toString();
        }

        private void dfs(char[] pre, int n, int i){
            if (i == n){
                String s = String.valueOf(pre).substring(left);
                if (s.equals("0")) return;  // jump from 0
                // update left
                if (n - left == nine){
                    left --;
                }
                res.append(s + ",");
                return;
            }
            for (char c:
                 nums) {
                if (c == '9') {
                    nine ++;
                }

                pre[i] = c;
                dfs(pre, n, i + 1);
            }
            nine --;
        }
    }
}
