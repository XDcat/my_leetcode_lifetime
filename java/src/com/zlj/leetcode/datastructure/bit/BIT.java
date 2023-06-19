package com.zlj.leetcode.datastructure.bit;

import java.util.Arrays;

public class BIT {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,0,3,-5,2,-1};
        BIT tree = new BIT(nums);
        System.out.println(tree.query(1, 6));
    }
    private int[] tree;
    private int[] nums;

    public BIT(int[] nums) {
        this.tree = new int[nums.length + 1];
        this.nums = nums;

        for (int i = 0; i < nums.length; i++) {
            add(nums[i], i + 1);
        }
        System.out.println(Arrays.toString(tree));
    }

    private int lowbit(int x) {
        return x & -x;
    }

    public void update(int x, int i){
        nums[i] = x;
        update(x - nums[i], i + 1);
    }
    private void add(int x, int i) {
        while (i < tree.length) {
            tree[i] += x;
            i = i + lowbit(i);
        }
    }

    private int query(int i) {
        int res = 0;
        while (i > 0) {
            res += tree[i];
            i = i - lowbit(i);
        }
        return res;
    }

    private int query(int lo, int hi) {
        return query(hi) - query(lo - 1);
    }
}
