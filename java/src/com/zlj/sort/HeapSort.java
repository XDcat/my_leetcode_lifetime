package com.zlj.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class HeapSort {
    public static void main(String[] args) {
        HeapSort hs = new HeapSort();
        int[] nums = {9, 4, 7, 2, 1, 8};
        hs.sort(nums);
        System.out.println(Arrays.toString(nums));
        Integer[] nums2 = {8, 23, 5, 2};
        Arrays.sort(nums2, (x, y) -> (y - x));
        System.out.println(Arrays.toString(nums2));
    }
    public void sort(int[] nums){
        int N = nums.length;
        for (int i = N / 2 - 1; i >=0; i --){
            sink(nums, i, N - 1);
        }

        while (N > 0){
            swap(nums, 0, N - 1);
            N--;
            sink(nums, 0, N - 1);
        }
    }
    public void sink(int[] nums, int lo, int hi){
        // from top to button
        int i = lo;
        while (2 * i + 1 <= hi){
            int j = 2 * i + 1;
            if (j + 1 <= hi && nums[j+1] > nums[j]) {
                j++;
            }
            if (nums[i] > nums[j]){
                break;
            }
            swap(nums, i, j);
            i = j;
        }
    }

    public void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i]  =nums[j];
        nums[j] = t;
    }
}
