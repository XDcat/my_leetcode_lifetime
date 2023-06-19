package com.zlj.leetcode.normal.q303.bit;

public class Main {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2)); // return 1 ((-2) + 0 + 3)
        System.out.println(numArray.sumRange(2, 5)); // return -1 (3 + (-5) + 2 + (-1))
        System.out.println(numArray.sumRange(0, 5)); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
    }
}

class NumArray {
    private int[] tree;

    public NumArray(int[] nums) {
        tree = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            update(nums[i], i + 1);
        }
    }

    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }

    private int lowbit(int x) {
        return x & -x;
    }

    private void update(int x, int i) {
        while (i < tree.length) {
            tree[i] += x;
            i += lowbit(i);
        }
    }

    private int query(int i) {
        int res = 0;
        while (i > 0) {
            res += tree[i];
            i -= lowbit(i);
        }
        return res;
    }
}