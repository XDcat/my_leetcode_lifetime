package com.zlj.leetcode.offerjianzhi.q37.s3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main{
    public static void main(String[] args) {
        Codec c = new Codec();
        TreeNode h = c.deserialize("1,2,3,null,null,4,5");
        System.out.println(c.serialize(h));
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // bfs
        List<String> arr = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.offer(root);
        while (q.size() > 0){
            for (int i = q.size(); i > 0; i--){
                TreeNode h = q.poll();
                if (h != null) {
                    arr.add("" + h.val);
                    q.offer(h.left);
                    q.offer(h.right);
                } else {
                    arr.add("null");
                }
                // if (h.left != null) q.offer(h.left);
                // if (h.right != null) q.offer(h.right);
            }
        }

        return String.join(",", arr);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int idx = 1;
        while (idx < arr.length){
            TreeNode h = q.poll();
            h.left = (arr[idx].equals("null"))? null :  new TreeNode(Integer.parseInt(arr[idx]));
            idx++;
            h.right = (arr[idx].equals("null"))? null :  new TreeNode(Integer.parseInt(arr[idx]));
            idx++;
            if (h.left != null) q.offer(h.left);
            if (h.right != null) q.offer(h.right);
        }
        return root;
    }
}