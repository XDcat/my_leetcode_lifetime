package com.zlj.leetcode.datastructure.segmenttree.s1;

public class SegmentTree {
    private int[] tree;
    private int[] nums;

    public SegmentTree(int[] nums) {
        this.nums = nums;
        tree = new int[4 * this.nums.length];
        build(0, nums.length - 1, 0);
    }

    /**
     * 构建树
     *
     * @param lo nums 的下限
     * @param hi nums 的上限(可达!!)
     * @param i  tree 的索引
     */
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
        tree[i] = merger(tree[leftChild], tree[rightChild]);  // 合并
    }

    /**
     * 合并节点。
     * e.g. 求和-加法，最大值-max等;
     */
    private int merger(int a, int b) {
        return a + b;
    }

    /**
     * 查询从 left 到 right 的区间相应结果。
     * @param left  左区间
     * @param right 右区间（可达）
     */
    public int query(int left, int right) {
        return query(left, right, 0, nums.length - 1, 0);
    }

    /**
     * 在以 i 为根节点，区间为 [lo, hi] 范围内搜索 [queryL, queryR];
     */
    public int query(int queryL, int queryR, int lo, int hi, int i) {
        if (queryL == lo && queryR == hi) {
            return tree[i];
        }

        int mid = lo + (hi - lo) / 2;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (mid < queryL) {
            // 偏向右边
            return query(queryL, queryR, mid + 1, hi, rightChild);
        } else if (mid >= queryR) {
            // 偏向左边
            return query(queryL, queryR, lo, mid, leftChild);
        } else {
            // 两边都需要寻找
            int leftRes = query(queryL, mid, lo, mid, leftChild);
            int rightRes = query(mid + 1, queryR, mid + 1, hi, rightChild);
            return leftRes + rightRes;
        }
    }

    /**
     * 更新 nums[i] 为 value
     */
    public void update(int i, int value){
        update(i, value, 0, nums.length - 1, 0);
    }

    private void update(int numIndex, int value, int lo, int hi, int treeIndex){
        if (lo == hi){
            tree[treeIndex] = value;
            return;
        }

        int mid = lo + (hi - lo) / 2;
        int leftChild = 2 * treeIndex + 1;
        int rightChild = 2 * treeIndex + 2;
        if (numIndex <= mid){
            // 左子树更新
            update(numIndex, value, lo, mid, leftChild);
        } else{
            // 右子树更新
            update(numIndex, value, mid + 1, hi, rightChild);
        }
        // 当前更新
        tree[treeIndex] = merger(tree[leftChild], tree[rightChild]);
    }
}
