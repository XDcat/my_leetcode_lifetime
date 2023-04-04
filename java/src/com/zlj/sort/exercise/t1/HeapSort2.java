package com.zlj.sort.exercise.t1;

import java.util.Arrays;

public class HeapSort2 {
    public static void main(String[] args) {
        int[] nums = {2, 4, 52, 1, 56, 0, 2, 1, 1, 3, 4, 3};
        HeapSort2 sort = new HeapSort2();
        sort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }


    /**
     * Sort from small to large
     * -> big heap
     *
     * @param nums
     */
    public void sort(int[] nums) {
        // generate heap
        for (int i = nums.length / 2; i >= 0; i--) {
            sink(nums, i, nums.length - 1);
        }

        // find the biggest one and swap
        for (int i = 0; i < nums.length; i++) {
            swap(nums, 0, nums.length - 1 - i);
            sink(nums, 0, nums.length - 2 - i);
        }
    }

    private void sink(int[] nums, int i, int hi) {
        int j;
        while (2 * i + 1 <= hi) {
            // find the max child
            j = 2 * i + 1;
            if (j + 1 <= hi && nums[j + 1] > nums[j]) {
                j++;
            }

            // satisfied -> jump out
            if (nums[i] > nums[j]) {
                break;
            }

            swap(nums, i, j);
            i = j;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
