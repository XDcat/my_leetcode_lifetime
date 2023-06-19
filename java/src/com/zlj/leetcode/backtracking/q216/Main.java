package com.zlj.leetcode.backtracking.q216;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.combinationSum3(3, 9);
        System.out.println(res);
    }
}

class Solution {
    private List<List<Integer>> res;
    private int k;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        this.k = k;
        backtracking(new ArrayList<>(), n, 1);
        return res;
    }

    private void backtracking(List<Integer> path, int leave, int lo){
        if (path.size() == k){
            if (leave == 0){
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = lo; i <= Math.min(9 - (k - path.size()) + 1, leave); i++) {
            path.add(i);
            backtracking(path, leave - i, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
