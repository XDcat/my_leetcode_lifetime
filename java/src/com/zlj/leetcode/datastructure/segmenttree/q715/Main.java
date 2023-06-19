package com.zlj.leetcode.datastructure.segmenttree.q715;

public class Main {
    public static void main(String[] args) {
        RangeModule rangeModule = new RangeModule();
        rangeModule.addRange(10, 180);
        System.out.println(rangeModule.queryRange(50, 100)); // 返回 true （区间 [10, 14) 中的每个数都正在被跟踪）
    }
}

class RangeModule {
    private SegmentTree tree;

    public RangeModule() {
        tree = new SegmentTree((int) 1e9);
    }

    public void addRange(int left, int right) {
        tree.addRange(left, right - 1);
    }

    public boolean queryRange(int left, int right) {
        return tree.queryRange(left, right - 1);
    }

    public void removeRange(int left, int right) {
        tree.removeRange(left, right - 1);
    }
}

class SegmentTree {
    class Node {
        Node left, right;
        boolean value, lazy;
    }

    private Node root;
    private int n;

    public SegmentTree(int n) {
        this.n = n;
        root = new Node();
    }

    private void addNode(Node node) {
        if (node.left == null) node.left = new Node();
        if (node.right == null) node.right = new Node();
    }

    private boolean merge(boolean a, boolean b) {
        return a && b;
    }

    private void pullDown(Node cur) {
        cur.left.value = cur.value;
        cur.left.lazy = cur.lazy;
        cur.right.value = cur.value;
        cur.right.lazy = cur.lazy;
        cur.lazy = false;
    }

    private void pullUp(Node cur) {
        cur.value = merge(cur.left.value, cur.right.value);
    }

    public void addRange(int left, int right) {
        update(left, right, true, 0, n, root);
    }

    public void removeRange(int left, int right) {
        update(left, right, false, 0, n, root);
    }


    private void update(int left, int right, boolean value, int lo, int hi, Node cur) {
        if (left <= lo && hi <= right) {
            cur.value = value;
            if (lo != hi) cur.lazy = true;
            return;
        }
        addNode(cur);
        int mid = lo + (hi - lo) / 2;
        if (cur.lazy) pullDown(cur);
        if (left <= mid) update(left, right, value, lo, mid, cur.left);
        if (right > mid) update(left, right, value, mid + 1, hi, cur.right);
        pullUp(cur);
    }

    public boolean queryRange(int left, int right) {
        return queryRange(left, right, 0, n, root);
    }

    private boolean queryRange(int left, int right, int lo, int hi, Node cur) {
        if (left <= lo && hi <= right) {
            return cur.value;
        }
        int mid = lo + (hi - lo) / 2;
        addNode(cur);
        if (cur.lazy) pullDown(cur);
        boolean leftRes = (left <= mid) ? queryRange(left, right, lo, mid, cur.left) : true;
        boolean rightRes = (right > mid) ? queryRange(left, right, mid + 1, hi, cur.right) : true;
        return merge(leftRes, rightRes);
    }
}