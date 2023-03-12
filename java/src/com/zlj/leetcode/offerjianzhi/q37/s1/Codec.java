package com.zlj.leetcode.offerjianzhi.q37.s1;

import java.util.List;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return null;
    }

    private void pDFS(TreeNode root, List<Integer> nums){
        if (root == null){
            return;
        }

        nums.add(root.val);
        pDFS(root.left, nums);
        pDFS(root.right, nums);
    }

    private void mDFS(TreeNode root, List<Integer> nums){
        if (root == null){
            return;
        }

        nums.add(root.val);
        pDFS(root.left, nums);
        pDFS(root.right, nums);

    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
