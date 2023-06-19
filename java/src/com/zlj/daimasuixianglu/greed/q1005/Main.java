package com.zlj.daimasuixianglu.greed.q1005;

import java.util.Arrays;

public class Main {
}

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        nums = Arrays.stream(nums).boxed().sorted((a, b) -> Math.abs(a) - Math.abs(b)).mapToInt(i -> i).toArray();
        for (int i = 0; i < nums.length && k > 0; i++) {
             if (nums[i] < 0){
                 nums[i] = -nums[i];
                 k--;
             }
        }

        if (k % 2 == 1){
            nums[nums.length - 1] = -nums[nums.length - 1];
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
        }

        return res;
    }
}