package com.zlj.leetcode.backtracking.q40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(res);

    }
}

class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        boolean[] used = new boolean[candidates.length];
        Arrays.sort(candidates);
        backtracking(candidates, used, target, 0, new ArrayList<>());
        return res;
    }

    private void backtracking(int[] candidates, boolean[] used, int target, int start, List<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }

            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }

            path.add(candidates[i]);
            target -= candidates[i];
            used[i] = true;

            backtracking(candidates, used, target, i + 1, path);

            used[i] = false;
            target += candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
