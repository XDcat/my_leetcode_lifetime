package com.zlj.leetcode.normal.q51.s1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> res = solution.solveNQueens(4);
        System.out.println(res);
    }
}
class Solution {
    List<List<String>> res;
    char[][] table;
    Set<Integer> col;
    Set<Integer> ob1;
    Set<Integer> ob2;

    public List<List<String>> solveNQueens(int n) {
        // init
        res = new ArrayList<>();
        col = new HashSet<>();
        ob1 = new HashSet<>();
        ob2 = new HashSet<>();
        table = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(table[i], '.');
        }
        dfs(0, n);
        return res;
    }

    private void dfs(int i, int n){
        if (i >= n){
            List<String> strings = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                strings.add(String.valueOf(table[j]));
            }
            res.add(strings);
            return;
        }

        for (int j = 0; j < n; j++) {
            // not satisfied
            if (col.contains(j) || ob1.contains(j - i) || ob2.contains(i + j)){
                continue;
            }

            table[i][j] = 'Q';
            col.add(j);
            ob1.add(j - i);
            ob2.add(i + j);

            dfs(i + 1, n);

            table[i][j] = '.';
            col.remove(j);
            ob1.remove(j - i);
            ob2.remove(i + j);
        }
    }
}
