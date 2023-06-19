package com.zlj.leetcode.backtracking.q17;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.letterCombinations("23");
        System.out.println(strings);
    }
}

class Solution {
    private String[] map = new String[]{
            "",
            "",
            "abc", // 2
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };
    private List<String> res;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits.length() == 0){
            return res;
        }
        backtracking(new ArrayList<>(), digits, 0);
        return res;
    }

    private void backtracking(List<String> path, String digits, int index){
        if (index == digits.length()){
            res.add( String.join("", path) );
            return;
        }

        int digit = Integer.parseInt(digits.substring(index, index + 1));
        for (int i = 0; i < map[digit].length(); i++) {
            path.add(map[digit].substring(i, i+1));
            backtracking(path, digits, index + 1);
            path.remove(path.size() - 1);
        }
    }
}
