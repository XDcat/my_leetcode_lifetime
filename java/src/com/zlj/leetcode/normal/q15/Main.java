package com.zlj.leetcode.normal.q15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                break;
            }
            if (i > 0 && nums[i] == nums[i -1]){
                continue;
            }

            int left = i + 1, right = nums.length - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0){
                    left++;
                } else if (sum > 0){
                    right--;
                } else {
                    int[] t = new int[]{nums[i], nums[left], nums[right]};
                    res.add(Arrays.stream(t).boxed().collect(Collectors.toList()));

                    while (left + 1 < nums.length && nums[left] == nums[left +1]){
                        left++;
                    }
                    while (right - 1 >= 0 && nums[right] == nums[right - 1]){
                        right--;
                    }

                    left++; right--;
                }
            }
        }
        return res;
    }
}
