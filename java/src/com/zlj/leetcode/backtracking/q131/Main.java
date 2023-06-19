package com.zlj.leetcode.backtracking.q131;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> aab = solution.partition("aab");
        System.out.println(aab);
    }
}

class Solution {
    List<List<String>> res;
    String string;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        string = s;
        backtracking(new ArrayList<>(), 0);
        return res;
    }

    private void backtracking(List<String> path, int start){
        if (start == string.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start + 1; i <= string.length(); i++) {
            if (!valid(string.substring(start, i))){
                continue;
            }
            path.add(string.substring(start, i));
            backtracking(path, i);
            path.remove(path.size() - 1);
        }
    }

    private boolean valid(String s){
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
}