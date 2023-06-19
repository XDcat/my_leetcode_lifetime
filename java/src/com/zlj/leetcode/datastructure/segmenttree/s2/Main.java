package com.zlj.leetcode.datastructure.segmenttree.s2;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(-3, 5));
    }
}
class NumArray {
    private SegmentTree tree;
    public NumArray(int[] nums) {
        tree = new SegmentTree(nums);
    }

    public void update(int index, int val) {
        tree.update(index, val);
    }

    public int sumRange(int left, int right) {
        return tree.query(left, right);
    }
}

class SegmentTree{
    private int[] tree;
    private int[] nums;

    public SegmentTree(int[] nums){
        this.nums = nums;
        tree = new int[nums.length * 4];
        build(0, nums.length - 1, 0);
    }
    private int merger(int a, int b){
        return a + b;
    }
    private void build(int lo, int hi, int i){
        if (lo == hi){
            tree[i] = nums[lo];
            return;
        }
        int mid = lo + (hi - lo) / 2;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        build(lo, mid, leftChild);
        build(mid + 1, hi, rightChild);
        tree[i] = merger(tree[leftChild], tree[rightChild]);
    }
    public int query(int queryLeft, int queryRight){
        return query(queryLeft, queryRight, 0, nums.length -1 , 0);
    }

    private int query(int queryLeft, int queryRight, int lo, int hi, int i){
        if (queryLeft <= lo && hi <= queryRight){
            // bigger range -> return
            return tree[i];
        }
        int mid = lo + (hi - lo) / 2;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        // cal
        int res = 0;
        if (queryLeft <= mid){
            res += query(queryLeft, queryRight, lo, mid, leftChild);
        }
        if (queryRight > mid){
            res += query(queryLeft, queryRight, mid + 1, hi, rightChild);
        }
        return res;
    }

    public void update(int i, int value){
        update(i, value, 0, nums.length - 1, 0);
    }

    private void update(int i, int value, int lo, int hi, int treeIndex){
        if (lo == hi){
            tree[treeIndex] = value;
            return;
        }
        int mid = lo + (hi - lo) / 2;
        int leftChild = 2 * treeIndex + 1;
        int rightChild = 2 * treeIndex + 2;
        if (i <= mid){
            update(i, value, lo, mid, leftChild);
        } else {
            update(i, value, mid + 1, hi, rightChild);
        }

        tree[treeIndex] = merger(tree[leftChild], tree[rightChild]);
    }
}