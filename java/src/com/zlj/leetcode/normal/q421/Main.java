package com.zlj.leetcode.normal.q421;

import java.security.cert.TrustAnchor;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3,10,5,25,2,8};
        int res = solution.findMaximumXOR(nums);
        System.out.println(res);
    }
}

class Solution {
    private static int MAX_SIZE=30;  // max bit
    private Trie root;
    public int findMaximumXOR(int[] nums) {
        int res = 0;
        root = new Trie();
        for (int i = 1; i < nums.length; i++) {
            add(nums[i - 1]);
            res = Math.max(res, search(nums[i]));
        }
        return res;
    }

    private void add(int n){
        Trie cur = root;
        for(int i = MAX_SIZE; i >= 0; i--){
            int child = (n >> i) & 1;
            if (cur.children[child] == null){
                cur.children[child] = new Trie();
            }
            cur = cur.children[child];
        }
    }

    private int search(int n){
        Trie cur = root;
        int res = 0;
        for (int i = MAX_SIZE; i >= 0; i--){
            int child = (n >> i) & 1;
            if (cur.children[child ^ 1] != null){
                res = res * 2 + 1;
                cur = cur.children[child ^ 1];
            } else {
                res = res * 2;
                cur = cur.children[child];
            }
        }
        return res;
    }
}

class Trie{
    // 0 - left, 1, right
    Trie[] children = new Trie[2];
}