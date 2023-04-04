package com.zlj.sort.exercise.t1;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {2, 4, 52, 1, 56, 0, 2, 1, 1, 3, 4, 3};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    /**
     * From small to large.
     * So need big heap.
     * @param nums
     */
    public void sort(int[] nums){
        // pre-half to sink
        for (int i = nums.length / 2; i >= 0; i--) {
            sink(nums, i, 0, nums.length - 1);
        }
        System.out.println("heap -> " +Arrays.toString(nums));

        // swap and sink
        for (int i = 0; i < nums.length; i++) {
            swap(nums, 0, nums.length - i - 1);
            sink(nums, 0, 0, nums.length - i - 2);
            System.out.println(Arrays.toString(nums));
        }
    }

    private void swap(int[] nums, int i, int i1) {
        int t = nums[i];
        nums[i] = nums[i1];
        nums[i1] = t;
    }

    private void sink(int[] nums, int i, int lo, int hi){
        int j;
        while (i * 2 + 1 <= hi){
            // find the biggest child
            j = 2 * i + 1;
            if (j < hi && nums[j] < nums[j + 1]){
                j++;
            }
            // if satisfied -> node > child
            if (nums[i] > nums[j]){
                break;
            }

            swap(nums, i, j);
            i = j;
        }
    }

}
