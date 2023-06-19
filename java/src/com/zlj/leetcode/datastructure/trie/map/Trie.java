package com.zlj.leetcode.datastructure.trie.map;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    TreeNode root;

    public Trie() {
        root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TreeNode());
            }
            cur =cur.children.get(c);
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        TreeNode cur = root;
        for (char c :
                word.toCharArray()) {
            if (!cur.children.containsKey(c)){
                return false;
            }
            cur = cur.children.get(c);
        }
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        TreeNode cur = root;
        for (char c :
                prefix.toCharArray()) {
            if (!cur.children.containsKey(c)){
                return false;
            }
            cur = cur.children.get(c);
        }
        return true;
    }

    class TreeNode {
        Map<Character, TreeNode> children;
        boolean isEnd;

        public TreeNode() {
            children = new HashMap<>();
            isEnd = false;
        }
    }
}

