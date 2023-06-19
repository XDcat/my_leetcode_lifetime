package com.zlj.leetcode.datastructure.segmenttree.q699.s2;

import java.util.ArrayList;
import java.util.List;

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
        List<Integer> res = new ArrayList<>();
        SegmentTree tree = new SegmentTree((int) 1e9);
        int max = 0;
        for (int[] row :
                positions) {
            int left = row[0];
            int right = left + row[1] - 1;
            // range query
            int h = tree.query(left, right);
            // range update
            tree.update(left, right, h + row[1]);
            // add result
            max = Math.max(max, h + row[1]);
            res.add(max);
        }

        return res;
    }
}

class SegmentTree{
    class Node{
        Node left, right;
        int value, lazy;
    }

    private Node root;
    private int n;

    public SegmentTree(int n) {
        this.n = n;
        root = new Node();
    }
    private int merge(int a, int b){
        return Math.max(a, b);
    }
    private void addNode(Node node){
        if (node.left == null) node.left = new Node();
        if (node.right == null) node.right = new Node();
    }
    private void pullDown(Node cur) {
        cur.left.value = cur.value;
        cur.left.lazy = cur.lazy;
        cur.right.value = cur.value;
        cur.right.lazy = cur.lazy;
        cur.lazy = 0;
    }
    private void pullUp(Node cur) {
        cur.value = merge(cur.left.value, cur.right.value);
    }
    public void update(int left, int right, int value){
        update(left, right, value, 0, n - 1, root);
    }
    private void update(int left, int right, int value, int lo, int hi, Node cur){
        if (left <= lo && hi <= right){
            cur.value = value;
            if (lo != hi){
                cur.lazy = value;
            }
            return;
        }
        addNode(cur);
        int mid = lo + (hi - lo) / 2;
        if (cur.lazy != 0) pullDown(cur);
        if (left <= mid) update(left, right, value, lo, mid, cur.left);
        if (right > mid) update(left, right, value, mid + 1, hi, cur.right);
        pullUp(cur);
    }



    public int query(int left, int right){
        return query(left, right, 0, n - 1, root);
    }

    public int query(int left, int right, int lo, int hi, Node cur){
        if (left <= lo && right >= hi){
            return cur.value;
        }
        int mid = lo + (hi - lo) / 2;
        addNode(cur);
        if (cur.lazy != 0) pullDown(cur);
        int leftRes = (left <= mid)? query(left, right, lo, mid, cur.left): 0;
        int rightRes = (right > mid)? query(left, right, mid + 1, hi, cur.right): 0;
        return merge(leftRes, rightRes);
    }
}


