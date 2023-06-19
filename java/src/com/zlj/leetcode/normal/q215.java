package com.zlj.leetcode.normal;

public class q215 {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int k = 1;
        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(nums, k));
    }
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickFind(nums, 0, nums.length - 1, k-1);
    }

    private int quickFind(int[] nums, int lo, int hi, int k){
        if (lo >= hi) return nums[lo];

        int p = partition(nums, lo, hi);

        if (p < k){
            return quickFind(nums, p + 1, hi, k);
        } else if (p > k){
            return quickFind(nums, lo, p - 1, k);
        } else {
            return nums[p];
        }
    }

    private int partition(int[] nums, int lo, int hi){
        int flag = nums[lo];
        int i = lo, j = hi + 1;
        while (true){
            while (nums[++i] >= flag){
                if (i == hi) break;
            }

            while (nums[--j] <= flag){
                if (j == lo) break;
            }

            if (i >= j) break;

            swap(nums, i, j);
        }

        swap(nums, lo, j);
        return j;
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
