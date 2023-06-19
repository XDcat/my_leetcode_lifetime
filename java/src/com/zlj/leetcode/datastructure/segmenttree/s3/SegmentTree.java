package com.zlj.leetcode.datastructure.segmenttree.s3;

public class SegmentTree {
    private int[] tree, nums;
    private int n;

    public SegmentTree(int[] nums) {
        this.nums = nums;
        tree = new int[4 * n];
        build(0, n - 1, 0);
    }

    private int merge(int a, int b) {
        return a + b;
    }

    private void build(int lo, int hi, int i) {
        if (lo == hi) {
            tree[i] = nums[lo];
            return;
        }
        int mid = lo + (hi - lo) / 2;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        build(lo, mid, leftChild);
        build(mid + 1, hi, rightChild);
        tree[i] = merge(tree[leftChild], tree[rightChild]);
    }

    public void add(int i, int value) {
        add(i, value, 0, n - 1, 0);
    }

    public void update(int i, int value) {
        update(i, value, 0, n - 1, 0);
    }

    private void add(int i, int value, int lo, int hi, int treeIndex) {
        if (lo == hi) {
            tree[treeIndex] += value;
            return;
        }
        int mid = lo + (hi - lo) / 2;
        int leftChild = 2 * treeIndex + 1;
        int rightChild = 2 * treeIndex + 2;
        if (i <= mid) {
            add(i, value, lo, mid, leftChild);
        } else {
            add(i, value, mid + 1, hi, rightChild);
        }
        tree[treeIndex] = merge(tree[leftChild], tree[rightChild]);
    }

    private void update(int i, int value, int lo, int hi, int treeIndex) {
        if (lo == hi) {
            tree[treeIndex] = value;
            return;
        }
        int mid = lo + (hi - lo) / 2;
        int leftChild = 2 * treeIndex;
        int rightChild = 2 * treeIndex + 1;
        if (i <= mid) {
            update(i, value, lo, mid, leftChild);
        } else {
            update(i, value, mid + 1, hi, rightChild);
        }
        tree[treeIndex] = merge(tree[leftChild], tree[rightChild]);
    }

    public int query(int i) {
        return query(i, 0, n - 1, 0);
    }

    private int query(int i, int lo, int hi, int treeIndex) {
        if (lo == hi) {
            return tree[treeIndex];
        }
        int mid = lo + (hi - lo) / 2;
        int leftChild = 2 * treeIndex;
        int rightChild = 2 * treeIndex + 1;
        if (i <= mid) {
            return query(i, lo, mid, leftChild);
        } else {
            return query(i, mid + 1, hi, rightChild);
        }
    }

    public int sum(int queryLeft, int queryRight) {
        return sum(queryLeft, queryRight, 0, n - 1, 0);
    }

    private int sum(int queryLeft, int queryRight, int lo, int hi, int treeIndex) {
        if (queryLeft <= lo && hi <= queryRight) {
            return tree[treeIndex];
        }
        int mid = lo + (hi - lo) / 2;
        int leftChild = 2 * treeIndex;
        int rightChild = 2 * treeIndex + 1;
        int res = 0;
        if (queryLeft <= mid) {
            res += sum(queryLeft, mid, lo, mid, leftChild);
        }
        if (queryRight > mid) {
            res += sum(mid + 1, queryRight, mid + 1, hi, rightChild);
        }
        return res;
    }

}
