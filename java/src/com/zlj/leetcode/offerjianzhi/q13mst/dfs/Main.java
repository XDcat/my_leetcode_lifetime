package com.zlj.leetcode.offerjianzhi.q13mst.dfs;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.movingCount(11, 8, 16));
        System.out.println(Arrays.deepToString(solution.visited));
    }
}

class Solution {
    boolean[][] visited;
    int m, n, k;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;

        visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }

    /**
     * @param i  x
     * @param j  y
     * @param si sum of x
     * @param sj sum of y
     * @return
     */
    private int dfs(int i, int j, int si, int sj) {
        if (i >= m || j >= n || si + sj > k || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;

        return 1 + dfs(i, j + 1, si, ((j + 1) % 10 == 0) ? sj - 8 : sj + 1)
                + dfs(i + 1, j, ((i + 1) % 10 == 0) ? si - 8 : si + 1, sj);
    }
}
