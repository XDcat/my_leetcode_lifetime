package com.zlj.leetcode.datastructure.trie.array;


public class Trie {
    TreeNode root;

    public Trie() {
        root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.contains(c)){
                cur.set(c, new TreeNode());
            }
            cur =cur.get(c);
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        TreeNode cur = root;
        for (char c :
                word.toCharArray()) {
            if (!cur.contains(c)){
                return false;
            }
            cur = cur.get(c);
        }
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        TreeNode cur = root;
        for (char c :
                prefix.toCharArray()) {
            if (!cur.contains(c)){
                return false;
            }
            cur = cur.get(c);
        }
        return true;
    }

    class TreeNode {
        TreeNode[] children;
        boolean isEnd;

        public TreeNode() {
            children = new TreeNode[26];
            isEnd = false;
        }

        public boolean contains(char c){
            int i = c - 'a';
            if (i >= 0 && i < 26 && children[i] != null){
                return true;
            } else {
                return false;
            }
        }

        public TreeNode get(char c){
            if (contains(c)){
                return children[c - 'a'];
            } else {
                return null;
            }
        }

        public boolean set(char c, TreeNode node){
            int i = c - 'a';
            if (i>=0 && i < 26){
                children[i] = node;
                return true;
            } else {
                return false;
            }
        }
    }
}

