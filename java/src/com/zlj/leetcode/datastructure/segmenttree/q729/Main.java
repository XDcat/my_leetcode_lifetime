package com.zlj.leetcode.datastructure.segmenttree.q729;

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
        if (tree.sum(start, end - 1) == 0) {
            tree.add(start, end - 1, 1);
            return true;
        } else {
            return false;
        }
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
        cur.left.value += cur.lazy * (mid - lo + 1);
        cur.left.lazy += cur.lazy;
        cur.right.value += cur.lazy * (hi - mid);
        cur.right.lazy += cur.lazy;
        cur.lazy = 0;
    }

    private void pullUp(Node cur) {
        cur.value = cur.left.value + cur.right.value;
    }

    public void add(int left, int right, int value) {
        add(left, right, value, 0, n, root);
    }

    private void add(int left, int right, int value, int lo, int hi, Node cur) {
        if (left <= lo && hi <= right) {
            cur.value += (hi - lo + 1) * value;
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

    public int sum(int left, int right) {
        return sum(left, right, 0, n, root);
    }

    private int sum(int left, int right, int lo, int hi, Node cur) {
        if (left <= lo && hi <= right) {
            return cur.value;
        }

        addNode(cur);
        int mid = lo + (hi - lo) / 2;
        if (cur.lazy != 0) {
            pullDown(cur, lo, mid, hi);
        }
        int leftRes = (left <= mid) ? sum(left, right, lo, mid, cur.left) : 0;
        int rightRes = (right >= mid + 1) ? sum(left, right, mid + 1, hi, cur.right) : 0;
        return leftRes + rightRes;
    }
}
