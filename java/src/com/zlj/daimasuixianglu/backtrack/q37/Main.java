package com.zlj.daimasuixianglu.backtrack.q37;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    List<int[]> spaces;

    public void solveSudoku(char[][] board) {
        row = new boolean[n][n];
        col = new boolean[n][n];
        part = new boolean[m][m][n];
        spaces = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.')update(i, j, board[i][j], true);
                else spaces.add(new int[]{i, j});
            }
        }

        backtracking(board, 0);
    }

    private boolean backtracking(char[][] board, int idx) {
        if (idx == spaces.size()){
            return true;
        }

        int[] pos = spaces.get(idx);
        int i = pos[0], j = pos[1];

        for (int k = 1; k <= 9; k++) {
            char num = (char) ('0' + k);
            if (valid(i, j, num)){
                // update
                board[i][j] = num;
                update(i, j, num, true);

                // try
                boolean res = backtracking(board, idx + 1);
                if (res) return true;

                // back
                board[i][j] = '.';
                update(i, j, num, false);
            }
        }
        return false;
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
