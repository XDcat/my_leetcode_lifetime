package com.zlj.leetcode.backtracking.q77;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.combine(4, 4);
        System.out.println(res);
    }
}
class Solution {
    private List<List<Integer>> res;
    private int n;
    private int k;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        this.n = n;
        this.k = k;
        backtracking(new ArrayList<>(), 1);
        return res;
    }

    private void backtracking(List<Integer> cur, int lo){
        if (cur.size() == k){
            res.add(new ArrayList<>(cur));
            return;
        }

        /*
        NOTE: if i -> n less than k, can't get results.
              -> improve: lo -> n - (k - cur.size()) + 1
         */
        for (int i = lo; i <= n - (k - cur.size()) + 1; i++) {
            cur.add(i);
            backtracking(cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
