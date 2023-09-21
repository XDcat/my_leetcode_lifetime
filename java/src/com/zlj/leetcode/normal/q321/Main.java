package com.zlj.leetcode.normal.q321;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = new int[]{6, 7};
        int[] nums2 = new int[]{9, 1, 2, 5, 8, 3};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxNumber(nums1, nums2, 5)));
    }
}

class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[k];
        for (int i = 0; i <= k; i++) {
            if (i <= len1 && k - i <= len2) {
                int[] seq1 = findMaxSeq(nums1, i);
                int[] seq2 = findMaxSeq(nums2, k - i);
                int[] seq3 = merge(seq1, seq2);
                res = (compared(res, 0, seq3, 0) > 0 )? res: seq3;
            }
        }

        return res;
    }

    private int[] findMaxSeq(int[] nums, int k) {
        int length = nums.length;
        int[] stack = new int[length];
        int idx = 0;
        int remain = k;
        k = length - k;
        for (int n : nums) {
            while (idx > 0 && stack[idx - 1] < n && k > 0) {
                idx--;
                k--;
            }
            stack[idx++] = n;
        }

        return Arrays.copyOfRange(stack, 0, remain);
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0) {
            return nums2;
        }
        if (len2 == 0) {
            return nums1;
        }

        int[] aux = new int[len1 + len2];
        int i = 0, j = 0;
        for (int k = 0; k < len1 + len2; k++) {
            if (compared(nums1, i, nums2, j) > 0){
                aux[k] = nums1[i++];
            } else {
                aux[k] = nums2[j++];
            }
        }

        return aux;
    }

    private int compared(int[] nums1, int i, int[] nums2, int j) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        while (i < len1 && j < len2){
            int cmp = nums1[i] - nums2[j];
            if (cmp != 0){
                return cmp;
            }

            i++;
            j++;
        }

        return (len1 - i) - (len2 - j);
    }
}