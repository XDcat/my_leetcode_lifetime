package com.zlj.leetcode.offerjianzhi.q26.a1;

import java.util.LinkedList;
import java.util.Queue;


public class Solution {
    public static void main(String[] args) {
        TreeNode A = TreeNode.createTree(new Integer[]{10, 12, 6, 8, 3, 11});
        TreeNode B = TreeNode.createTree(new Integer[]{10, 12, 6, 8});
        Solution solution = new Solution();
        System.out.println(solution.isSubStructure(A, B));
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    public boolean dfs(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }

        if (A == null || A.val != B.val) {
            return false;
        }
        return dfs(A.left, B.left) || dfs(A.right, B.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static TreeNode createTree(Integer[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode head = new TreeNode(nums[0]);
        int index = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        while (index < nums.length) {
            TreeNode node = queue.poll();
            // left
            if (nums[index] != null) {
                node.left = new TreeNode(nums[index]);
                queue.offer(node.left);
            }
            index++;

            // right
            if (index < nums.length) {
                if (nums[index] != null) {
                    node.right = new TreeNode(nums[index]);
                    queue.offer(node.right);
                }
                index++;
            }
        }
        return head;
    }
}
