package com.zlj.leetcode.datastructure.segmenttree.q699.s1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 2},
                {2, 3},
                {6, 1}
        };

        Solution solution = new Solution();
        System.out.println(solution.fallingSquares(nums));
    }
}

class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        // 离散化 -> 找到所有边界信息，并找到最大的边界 size
        // 为什么要离散化？ 把离散的区间当作 0 1 2 ... 这样的区间来看
        int n = positions.length;
        int size = 0;
        int[] arr = new int[n * 2];
        for (int i = 0; i < n; i++) {
            arr[2 * i] = positions[i][0];  // left
            arr[2 * i + 1] = positions[i][0] + positions[i][1];  // right
            size = Math.max(size, arr[2 * i + 1]);
        }
        Map<Integer, Integer> map = discrete(arr);

        // 构建树
        SegmentTree tree = new SegmentTree(map.get(size) + 1);

        // 遍历寻找最大值
        List<Integer> res = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int left = map.get(positions[i][0]);
            int right = map.get(positions[i][0] + positions[i][1]) - 1;
            // 范围查询
            int h = tree.query(left, right);
            max = Math.max(max, h + positions[i][1]);
            // 范围更新
            tree.update(left, right, h + positions[i][1]);
            // 添加结果
            res.add(max);
        }
        return res;
    }

    private Map<Integer, Integer> discrete(int[] nums) {
        // 离散化数组，获取边界到 index 的 map
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int num :
                nums) {
            set.add(num);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }
        return map;
    }
}

/**
 * 线段树，最大值，更新方式
 */
class SegmentTree {
    private int[] tree;
    private int[] lazy;
    private int n;

    public SegmentTree(int n) {
        this.n = n;
        tree = new int[4 * n];
        lazy = new int[4 * n];
    }

    private int merge(int a, int b) {
        return Math.max(a, b);
    }

    public void update(int updateLeft, int updateRight, int value) {
        update(updateLeft, updateRight, value, 0, n - 1, 0);
    }
    private void update(int updateLeft, int updateRight, int value, int lo, int hi, int treeIndex){
        if (updateLeft <= lo && hi <= updateRight) {
            tree[treeIndex] = value;
            if (lo != hi){
                lazy[treeIndex] = value;
            }
            return;
        }

        int mid = lo + (hi - lo) / 2;
        int leftIndex = 2 * treeIndex + 1;
        int rightIndex = 2 * treeIndex + 2;
        // 惰性标记
        if (lazy[treeIndex] != 0) {
            pushDown(treeIndex);
        }
        if (updateLeft <= mid){
            update(updateLeft,updateRight, value, lo, mid, leftIndex);
        }
        if (updateRight > mid){
            update(updateLeft, updateRight, value, mid + 1, hi, rightIndex);
        }
        pushUp(treeIndex);
    }

    public int query(int queryLeft, int queryRight) {
        return query(queryLeft, queryRight, 0, n - 1, 0);
    }

    public int query(int queryLeft, int queryRight, int lo, int hi, int treeIndex) {
        if (queryLeft <= lo && hi <= queryRight) {
            return tree[treeIndex];
        }

        // 惰性标记
        if (lazy[treeIndex] != 0) {
            pushDown(treeIndex);
        }

        // 查询
        int mid = lo + (hi - lo) / 2;
        int leftIndex = 2 * treeIndex + 1;
        int rightIndex = 2 * treeIndex + 2;
        int lmax = 0, rmax = 0;
        if (queryLeft <= mid) {
            lmax = query(queryLeft, queryRight, lo, mid, leftIndex);
        }
        if (queryRight > mid) {
            rmax = query(queryLeft, queryRight, mid + 1, hi, rightIndex);
        }
        return merge(lmax, rmax);
    }

    private void pushDown(int treeIndex){
        // TODO: 为什么子节点直接等于父节点的 tree 的值
        int left = 2 * treeIndex + 1;
        int right = 2 * treeIndex + 2;
        tree[left] = tree[treeIndex];
        lazy[left] = lazy[treeIndex];
        tree[right] = tree[treeIndex];
        lazy[right] = tree[treeIndex];
        lazy[treeIndex] = 0;
    }
    private void pushUp(int treeIndex){
        int left = 2 * treeIndex + 1;
        int right = 2 * treeIndex + 2;
        tree[treeIndex] = merge(tree[left], tree[right]);
    }
}