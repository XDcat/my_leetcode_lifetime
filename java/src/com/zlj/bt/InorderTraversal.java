package com.zlj.bt;

import java.util.*;

public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode A = generateTree(new Integer[]{1, 2, 3, 4, null, 5, 6, null, null, 7});
        System.out.println(A);
        List<Integer> inorder = inorder(A);
        System.out.println(inorder);
    }
    public static List<Integer> inorder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (stack.size() > 0 || cur != null) {
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }
    public static TreeNode generateTree(Integer[] nums) {
        if (nums.length == 0) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode head = new TreeNode(nums[0]);
        queue.offer(head);
        int index = 1;
        while (index < nums.length) {
            TreeNode cur = queue.poll();
            // left
            if (nums[index] != null) {
                cur.left = new TreeNode(nums[index]);
                queue.offer(cur.left);
            }
            index++;

            if (index < nums.length) {
                if (nums[index] != null) {
                    cur.right = new TreeNode(nums[index]);
                    queue.offer(cur.right);
                }
                index++;
            }
        }

        return head;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
