package com.zlj.sort.exercise.t3;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {2, 4, 52, 1, 56, 0, 2, 1, 1, 3, 4, 3};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    private int[] aux;

    public void sort(int[] nums){
        aux = new int[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int lo, int hi){
        if (lo >= hi){;
            return;
        };
        int mid = lo + (hi - lo) / 2;;
        sort(nums, lo, mid);
        sort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private void merge(int[] nums, int lo,int mid, int hi){
        // copy
        for (int i = lo; i <= hi; i++){
            aux[i] = nums[i];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++){
            if (i > mid){
                nums[k] = aux[j++];
            } else if (j > hi){
                nums[k] = aux[i++];
            } else if (aux[i] > aux[j]){
                nums[k] = aux[j++];
            } else{
                nums[k] = aux[i++];
            }
        }
    }

    
    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}