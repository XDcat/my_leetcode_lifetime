package com.zlj.leetcode.datastructure.segmenttree.s1;


public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        SegmentTree segmentTree = new SegmentTree(nums);
        System.out.println(segmentTree.query(0, 2));
        System.out.println(segmentTree.query(2, 5));
        System.out.println(segmentTree.query(0, 5));
    }
}
