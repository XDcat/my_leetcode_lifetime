package com.zlj.sort.exercise.t2;

import java.util.Arrays;

public class QuickSort{
    public static void main(String[] args) {
        int[] nums = {2, 4, 52, 1, 56, 0, 2, 1, 1, 3, 4, 3};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void sort(int[] nums){
        sort(nums, 0, nums.length - 1);
    }
    private void sort(int[] nums, int lo, int hi){
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
        while (i < j){
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
            if (i >= j){
                break;
            }
            swap(nums, i, j);
        }

        swap(nums, lo, j);
        return j;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
