package com.zlj.leetcode.datastructure.segmenttree.q729.s1;

public class Main {
    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20)); // return True
        System.out.println(myCalendar.book(15, 25)); // return False ，这个日程安排不能添加到日历中，因为时间 15 已经被另一个日程安排预订了。
        System.out.println(myCalendar.book(20, 30)); // return True ，这个日程安排可以添加到日历中，因为第一个日程安排预订的每个时间都小于 20 ，且不包含时间 20 。
    }
}

class MyCalendar {
    SegmentTree tree;

    public MyCalendar() {
        int n = (int) Math.pow(10, 9);
        tree = new SegmentTree(n);
    }

    public boolean book(int start, int end) {
//        for (int i = 0; i < 30; i++) {
//            System.out.printf("%s:%s, ", i, tree.query(i, i));
//        }
//        System.out.println("\n------");
        boolean exist = tree.query(start, end - 1);
        if (!exist) {
            tree.update(start, end - 1, true);
        }
        return !exist;
    }
}

class SegmentTree {
    private class Node {
        boolean value;
        boolean lazy;
        boolean visited;
        Node left, right;
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

    private void pullDown(Node node) {
        node.left.value = node.value;
        node.left.lazy = node.lazy;
        node.left.visited = node.visited;
        node.right.value = node.value;
        node.right.lazy = node.lazy;
        node.right.visited = node.visited;
        node.visited = false;
    }

    private void pullUp(Node node) {
        node.value = node.left.value || node.right.value;
    }

    public void update(int left, int right, boolean value) {
        update(left, right, value, 0, n, root);
    }

    private void update(int left, int right, boolean value, int lo, int hi, Node node) {
        if (left <= lo && hi <= right) {
            node.value = value;
            if (lo != hi) {
                node.lazy = value;
                node.visited = true;
            }
            return;
        }
        addNode(node);
        int mid = lo + (hi - lo) / 2;
        if (node.visited){
            pullDown(node);
        }
        if (left <= mid) update(left, right, value, lo, mid, node.left);
        if (right > mid) update(left, right, value, mid + 1, hi, node.right);

        pullUp(node);
    }

    public boolean query(int left, int right) {
        return query(left, right, 0, n, root);
    }

    private boolean query(int left, int right, int lo, int hi, Node node) {
        if (left <= lo && hi <= right) {
            return node.value;
        }
        addNode(node);
        int mid = lo + (hi - lo) / 2;
        if (node.visited){
            pullDown(node);
        }
        boolean leftRes = (left <= mid) ? query(left, right, lo, mid, node.left) : false;
        boolean rightRes = (right > mid) ? query(left, right, mid + 1, hi, node.right) : false;
        return leftRes || rightRes;
    }
}
