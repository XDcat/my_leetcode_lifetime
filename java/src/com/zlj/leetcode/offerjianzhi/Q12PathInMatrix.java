package com.zlj.leetcode.offerjianzhi;

public class Q12PathInMatrix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.exist(new char[][]{
                {'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}
        }, "ABCCED");
        System.out.println(res);
    }
    static class Solution {
        private int[][] flag;
        private void initFlag(char[][] board){
            flag = new int[board.length][board[0].length];
        }
        public boolean exist(char[][] board, String word) {
            // find the first char
            for (int i = 0; i < board.length; i ++){
                for(int j = 0; j < board[0].length; j ++){
                    if (board[i][j] == word.charAt(0)){
                        initFlag(board);
                        boolean searchResult = DFS(board, i, j, word);
                        if (searchResult){
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        private Boolean DFS(char[][] board, int row, int col, String word){
            // End condition
            if (word.length() == 0){
                return true;
            }

            // out board
            if (row < 0 || row >= board.length || col < 0 || col >= board[0].length){
                return false;
            }
            // Visited, not match
            if (flag[row][col] != 0  || board[row][col] != word.charAt(0)){
                return false;
            }

            // dfs
            String sub = word.substring(1);
            flag[row][col] = 1;
            int[][] move = new int[][]{{row-1, col}, {row + 1, col}, {row, col - 1}, {row, col + 1}};
            for (int[] position: move ) {
                boolean res = DFS(board, position[0], position[1], sub);
                if (res) {
                    return true;
                }
            }
            flag[row][col] = 0;
            return false;
        }
    }
}
