package com.zlj.leetcode.backtracking.q39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.combinationSum(new int[]{2, 3, 5}, 1);
        System.out.println(res);

    }
}
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void backtracking(int[] candidates, int target, int start, List<Integer> path){
        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < candidates[start]){
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target){
                break;
            }
            path.add(candidates[i]);
            target -= candidates[i];

            backtracking(candidates, target, i, path);

            target += candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
