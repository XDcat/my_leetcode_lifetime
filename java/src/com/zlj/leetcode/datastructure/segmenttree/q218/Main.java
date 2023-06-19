package com.zlj.leetcode.datastructure.segmenttree.q218;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {0,2147483647,2147483647}
        };
        Solution solution = new Solution();
        System.out.println(solution.getSkyline(nums));
    }
}

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        SegmentTree tree = new SegmentTree(Integer.MAX_VALUE);
        Arrays.sort(buildings, (a, b) -> a[2] - b[2]);
        for (int[] row : buildings) {
            tree.update(row[0], row[1] - 1, row[2]);
        }

        // find all boundary
        int[] positions = new int[buildings.length * 2];
        int idx = 0;
        for (int[] row :
                buildings) {
            positions[idx++] = row[0];
            positions[idx++] = row[1];
        }

        Arrays.sort(positions);

        List<List<Integer>> res = new ArrayList<>();
        int h = 0;
        for (int i = 0; i < positions.length; i++) {
            int newHeight = tree.query(positions[i]);
            if (newHeight!=h){
                h = newHeight;
                res.add(List.of(positions[i], h));
            }
        }
        return res;
    }
}

class SegmentTree {
    Node root;
    int n;

    public SegmentTree(int n) {
        root = new Node();
        this.n = n;
    }

    private int merge(int a, int b) {
        return Math.max(a, b);
    }

    private void pushUp(Node node) {
        node.value = merge(node.left.value, node.right.value);
    }

    private void pushDown(Node node) {
        node.left.value = node.value;
        node.left.lazy = node.lazy;
        node.right.value = node.value;
        node.right.lazy = node.lazy;
        node.lazy = 0;
    }

    private void addNode(Node node) {
        if (node.left == null) node.left = new Node();
        if (node.right == null) node.right = new Node();
    }

    public void update(int addLeft, int addRight, int value) {
        update(addLeft, addRight, value, 0, n, root);
    }

    private void update(int addLeft, int addRight, int value, int lo, int hi, Node cur) {
        if (addLeft <= lo && hi <= addRight) {
            cur.value = value;
            if (lo != hi) {
                cur.lazy = value;
            }
            return;
        }
        addNode(cur);
        int mid = lo + (hi - lo) / 2;
        if (cur.lazy != 0) {
            pushDown(cur);
        }
        if (addLeft <= mid) update(addLeft, addRight, value, lo, mid, cur.left);
        if (addRight > mid) update(addLeft, addRight, value, mid + 1, hi, cur.right);
        pushUp(cur);
    }

    public int query(int queryIndex) {
        return query(queryIndex, 0, n, root);
    }

    private int query(int queryIndex, int lo, int hi, Node cur) {
        if (lo == hi) return cur.value;
        addNode(cur);
        int mid = lo + (hi - lo) / 2;
        if (cur.lazy != 0) pushDown(cur);
        if (queryIndex <= mid) return query(queryIndex, lo, mid, cur.left);
        else return query(queryIndex, mid + 1, hi, cur.right);
    }

    private class Node {
        int value, lazy;
        Node left, right;
    }
}

