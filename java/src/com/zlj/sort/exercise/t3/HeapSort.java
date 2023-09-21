package com.zlj.sort.exercise.t3;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {2, 4, 52, 1, 56, 0, 2, 1, 1, 3, 4, 3};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sort(int[] nums){
        // build big heap
        for (int i = nums.length / 2; i >= 0; i--){
            sink(nums, i, nums.length - 1);
        }

        // sort
        for (int i = 0; i < nums.length; i++){
            swap(nums, 0, nums.length - 1 - i);
            sink(nums, 0, nums.length - 1 - i - 1);
        }
    }

    private void sink(int[] nums, int i, int hi){
        int k = i;
        while (2 * i + 1 <= hi){
            // find the max child
            k = 2 * i + 1;
            if (k + 1 <= hi && nums[k + 1] > nums[k]){
                k ++;
            }

            if (nums[k] > nums[i]){
                swap(nums, k, i);
                i = k;
            } else {
                break;
            }
        }

    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
