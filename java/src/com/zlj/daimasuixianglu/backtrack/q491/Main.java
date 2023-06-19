package com.zlj.daimasuixianglu.backtrack.q491;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10,1,1,1,1,1};
        for (List<Integer> row: solution.findSubsequences(nums)){
            System.out.println(row);
        }
    }
}
class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        trackback(nums, path, 0);
        return res;
    }

    private void trackback(int[] nums, List<Integer> path, int idx){
        if (path.size() >= 2) res.add(new ArrayList<>(path));

        int[] used = new int[201];
        for (int i = idx; i < nums.length; i++){
            if (used[nums[i] + 100] != 0){
                continue;
            }
            if (path.size() == 0 || path.get(path.size() - 1) <= nums[i]){
                path.add(nums[i]);
                used[nums[i] + 100] ++;
                trackback(nums, path, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}