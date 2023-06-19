package com.zlj.leetcode.normal.q51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> res = solution.solveNQueens(1);
        System.out.println(res);
    }
}
class Solution {
    List<List<String>> res;
    char[][] table;
    boolean[] col;
    boolean[] ob1;
    boolean[] ob2;

    public List<List<String>> solveNQueens(int n) {
        // init
        res = new ArrayList<>();
        col = new boolean[n];
        ob1 = new boolean[2 * n + 1];
        ob2 = new boolean[2 * n + 1];
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
            if (col[j] || ob1[j - i + n] || ob2[i + j]){
                continue;
            }

            table[i][j] = 'Q';
            col[j] = true;
            ob1[j - i + n] = true;
            ob2[i + j] = true;

            dfs(i + 1, n);

            table[i][j] = '.';
            col[j] = false;
            ob1[j - i + n] = false;
            ob2[i + j] = false;
        }
    }
}
