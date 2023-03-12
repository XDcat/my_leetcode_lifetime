package com.zlj.leetcode.offerjianzhi.q39.s1;

import java.util.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        solution.majorityElement(nums);
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int res = nums[nums.length / 2];
        return res;
    }
}
