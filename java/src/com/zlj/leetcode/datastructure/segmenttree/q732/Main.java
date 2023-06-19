package com.zlj.leetcode.datastructure.segmenttree.q732;

public class Main {
    public static void main(String[] args) {
    }
}

class MyCalendarThree {
    private SegmentTree tree;
    private int n;
    public MyCalendarThree() {
        int n = (int) Math.pow(10, 9);
        this.n = n;
        tree = new SegmentTree(n);
    }

    public int book(int start, int end) {
        tree.add(start, end - 1, 1);
        return tree.max(0, n);
    }
}

class SegmentTree {
    private class Node {
        int value, lazy;
        Node left, right;
    }

    private Node root;
    private int n;

    public SegmentTree(int n) {
        this.n = n;
        root = new Node();
    }

    private void addNode(Node cur) {
        if (cur.left == null) cur.left = new Node();
        if (cur.right == null) cur.right = new Node();
    }

    private void pullDown(Node cur, int lo, int mid, int hi) {
        cur.left.value += cur.lazy;
        cur.left.lazy += cur.lazy;
        cur.right.value += cur.lazy;
        cur.right.lazy += cur.lazy;
        cur.lazy = 0;
    }

    private void pullUp(Node cur) {
        cur.value = Math.max(cur.left.value, cur.right.value);
    }

    public void add(int left, int right, int value) {
        add(left, right, value, 0, n, root);
    }

    private void add(int left, int right, int value, int lo, int hi, Node cur) {
        if (left <= lo && hi <= right) {
            cur.value += value;
            if (lo != hi) {
                cur.lazy += value;
            }
            return;
        }
        addNode(cur);
        int mid = lo + (hi - lo) / 2;
        if (cur.lazy != 0) {
            pullDown(cur, lo, mid, hi);
        }
        if (left <= mid) add(left, right, value, lo, mid, cur.left);
        if (right >= mid + 1) add(left, right, value, mid + 1, hi, cur.right);
        pullUp(cur);
    }

    public int max(int left, int right) {
        return max(left, right, 0, n, root);
    }

    private int max(int left, int right, int lo, int hi, Node cur) {
        if (left <= lo && hi <= right) {
            return cur.value;
        }

        addNode(cur);
        int mid = lo + (hi - lo) / 2;
        if (cur.lazy != 0) {
            pullDown(cur, lo, mid, hi);
        }
        int leftRes = (left <= mid) ? max(left, right, lo, mid, cur.left) : Integer.MIN_VALUE;
        int rightRes = (right >= mid + 1) ? max(left, right, mid + 1, hi, cur.right) : Integer.MIN_VALUE;
        return Math.max(leftRes, rightRes);
    }
}
