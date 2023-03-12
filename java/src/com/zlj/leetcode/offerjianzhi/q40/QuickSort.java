package com.zlj.leetcode.offerjianzhi.q40;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 3, 8, 0, 0, 2, 3, 3};
        QuickSort s = new QuickSort();
        s.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sort(int[] nums){
        sort(nums, 0, nums.length - 1);
    }
    public  void sort(int[] nums, int lo, int hi){
        if (lo >= hi){
            return;
        }

        int p = partition(nums, lo, hi);
        sort(nums, lo, p - 1);
        sort(nums, p + 1, hi);
    }

    private int partition(int[] nums, int lo, int hi){
        int flag = nums[lo];
        int i = lo, j = hi + 1;
        while (true){
            while (nums[++i] <= flag){
                if (i == hi){
                    break;
                }
            }

            while (nums[--j] >= flag){
                if (j == lo){
                    break;
                }
            }
            if (i >=j){
                break;
            }
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
