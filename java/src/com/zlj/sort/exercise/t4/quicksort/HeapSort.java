package com.zlj.sort.exercise.t4.quicksort;


import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {2, 4, 52, 1, 56, 0, 2, 1, 1, 3, 4, 3};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }


    public void sort(int[] nums){
        // build heap
        // big top heap
        int n = nums.length;
        for (int i = n / 2; i >= 0; i--){
            sink(nums, 0, n, i);
        }

        // sort: swap + sink
        for (int i = 0; i < n; i++){
            swap(nums, 0, n - 1 - i);
            sink(nums, 0, n - 1 - i, 0);
        }
    }

    public void sink(int[] nums, int lo, int hi, int k){
        // 2 * k + 1, 2 * k + 2
        while (2 * k + 1 < hi){
            int p = 2 * k + 1;
            if (p + 1 < hi && nums[p + 1] > nums[p]) p++;

            if (nums[k] < nums[p]){
                swap(nums, k, p);
                k = p;
            } else {
                break;
            }
        }
    }

    private void swap(int[] nums, int k, int p) {
        int t = nums[k];
        nums[k] = nums[p];
        nums[p] = t;
    }
}
