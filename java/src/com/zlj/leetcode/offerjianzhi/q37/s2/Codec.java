package com.zlj.leetcode.offerjianzhi.q37.s2;

import java.util.*;

public class Codec {
    public static void main(String[] args) {
//        Integer[] nums = {1,2,3,null,null,4,5};
        Integer[] nums = {};
        Codec c = new Codec();
        TreeNode deserialize = c.deserialize(nums);
        String serialize = c.serialize(deserialize);
        System.out.println(serialize);
        TreeNode deserialize1 = c.deserialize(serialize);
        System.out.println(deserialize1);
        System.out.println(c.serialize(deserialize1));

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Integer[] nums = serializeToArray(root);
        if (nums == null) {
            return "";
        }

        String arrays = Arrays.toString(nums);
        return arrays;
    }

    public Integer[] serializeToArray(TreeNode root) {
        if (root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> nums = new ArrayList<>();

        // BFS
        queue.offer(root);
        while (queue.size() > 0) {
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (node == null) {
                    nums.add(null);
                } else {
                    nums.add(node.val);

                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
        return nums.toArray(Integer[]::new);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.trim();
        // empty
        if (data.length() == 0) {
            return null;
        }

        // no empty
        data = data.substring(1, data.length() - 1);
        List<Integer> nums = new ArrayList<>();
        for (String s : data.split(",")) {
            s = s.trim();
            if (s.equals("null")) {
                nums.add(null);
            } else {
                nums.add(Integer.parseInt(s));
            }
        }

        return deserialize(nums.toArray(new Integer[0]));
    }

    private TreeNode deserialize(Integer[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode head = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        int index = 1;
        while (index < nums.length) {
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (nums[index] != null) {
                    node.left = new TreeNode(nums[index]);
                    queue.offer(node.left);
                }
                index++;

                if (index < nums.length && nums[index] != null) {
                    node.right = new TreeNode(nums[index]);
                    queue.offer(node.right);
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

    TreeNode(int x) {
        val = x;
    }
}


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
