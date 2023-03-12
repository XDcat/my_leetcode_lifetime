package com.zlj.leetcode.offerjianzhi.q32;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintBinaryTree {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                res.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}
