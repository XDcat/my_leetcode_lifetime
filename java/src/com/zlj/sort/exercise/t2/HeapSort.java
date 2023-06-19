package com.zlj.sort.exercise.t2;

public class HeapSort {
    /**
     * sort from small to large,
     * so need a big heap,
     * and when sinking, need to find the big one
     */
    public void sort(int[] nums) {
        // create heap
        int N = nums.length;
        for (int i = N / 2; i >= 0; i--) {
            sink(nums, i, N);
        }

        // sort
        for (int i = 0; i < nums.length; i++) {
            swap(nums, 0, N - 1);
            sink(nums, 0, N--);
        }
    }

    private void sink(int[] nums, int i, int hi) {
        // the child of i -> 2 * i + 1 and 2 * i + 2
        int k = i;
        while (2 * k + 1 <= hi) {
            k = 2 * k + 1;
            if (k + 1 <= hi && nums[k + 1] > nums[k]) {
                k++;
            }

            if (nums[k] < nums[i]) {
                break;
            }

            swap(nums, i, k);
            i = k;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
