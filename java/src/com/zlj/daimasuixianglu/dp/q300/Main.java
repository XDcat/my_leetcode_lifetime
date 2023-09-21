package com.zlj.daimasuixianglu.dp.q300;


class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{7, 7, 7, 7, 7};
        System.out.println(solution.lengthOfLIS(nums));
    }
}

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int end = 0;
        for (int n: nums){
            int i = 0, j = end;
            while (i < j){
                int mid = i + (j - i) / 2;
                if (dp[mid] < n){
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            if (j == end){
                dp[end++] = n;
            } else {
                dp[j] = n;
            }
        }

        return end;
    }
}