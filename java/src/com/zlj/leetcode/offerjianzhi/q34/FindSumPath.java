package com.zlj.leetcode.offerjianzhi.q34;

import java.util.*;

public class FindSumPath {
    public static void main(String[] args) {
        Integer[] nums = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        System.out.println(Arrays.toString(nums));
        TreeNode root = TreeNode.factory(nums);
        Solution s = new Solution();
        List<List<Integer>> lists = s.pathSum(root, 22);
        lists.forEach(System.out::println);
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

    public static TreeNode factory(Integer[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode head = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);

        int i = 1;
        while (i < nums.length) {
            for (int j = queue.size(); j > 0; j--) {
                TreeNode node = queue.poll();
                // left
                if (nums[i] != null){
                    node.left = new TreeNode(nums[i]);
                    queue.offer(node.left);
                }
                i ++;
                //right
                if (i < nums.length && nums[i] != null){
                    node.right = new TreeNode(nums[i]);
                    queue.offer(node.right);
                }
                i++;
            }
        }
        return head;
    }
}

class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList<List<Integer>>();
        Deque<Integer> path = new LinkedList<>();
        searchPath(root, target, path);
        return res;
    }

    private void searchPath(TreeNode root, int target, Deque<Integer> path) {
        System.out.println("target="+target+" path=" + path);
        if (root == null) {
            return;
        }

        path.offerLast(root.val);
        target = target - root.val;
        if (target == 0){
            res.add(new ArrayList<>(path));
        }

        searchPath(root.left, target, path);
        searchPath(root.right, target, path);
        path.pollLast();
    }

}