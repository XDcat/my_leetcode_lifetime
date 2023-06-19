package com.zlj.daimasuixianglu.backtrack.q37.s1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        Solution solution = new Solution();
        solution.solveSudoku(board);
        for (char[] row :
                board) {
            System.out.println(Arrays.toString(row));
        }
    }
}

class Solution {
    boolean[][] row, col;
    boolean[][][] part;
    int n = 9;
    int m = (int) Math.pow(n, 0.5);

    public void solveSudoku(char[][] board) {
        row = new boolean[n][n];
        col = new boolean[n][n];
        part = new boolean[m][m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.')update(i, j, board[i][j], true);
            }
        }

        backtracking(board);
    }

    private boolean backtracking(char[][] board) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') continue;
                for (int k = 1; k <= n; k++) {
                    char num = (char) ('0' + k);
                    if (valid(i, j, num)) {
                        board[i][j] = num;
                        update(i, j, num, true);
                        boolean res = backtracking(board);
                        if (res) return true;
                        board[i][j] = '.';
                        update(i, j, num, false);
                    }
                }
                return false;
            }
        }
        return true;
    }

    private void update(int i, int j, char num, boolean value) {
        int t = num - '1';
        row[i][t] = value;
        col[j][t] = value;
        part[i / m][j / m][t] = value;
    }

    private boolean valid(int i, int j, char num) {
        int t = num - '1';
        if (row[i][t] || col[j][t] || part[i / m][j / m][t]) {
            return false;
        } else {
            return true;
        }
    }
}
