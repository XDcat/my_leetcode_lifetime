package com.zlj.leetcode.normal.q1615;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int n = 4;
        int[][] roads = new int[][]{{0, 1}, {0, 3}, {1, 2}, {1, 3}};
        Solution s = new Solution();
        System.out.println(s.maximalNetworkRank(n, roads));
    }
}

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] adj = new int[n][n];
        for (int[] edge : roads) {
            int n0 = edge[0];
            int n1 = edge[1];
            adj[n0][n1] = 1;
            adj[n1][n0] = 1;
        }

        // BFS
        int maxRank = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int r = getRank(adj, n, i) + getRank(adj, n, j);
                if (adj[i][j] == 1){
                    r--;
                }
                maxRank = Math.max(maxRank, r);
//                System.out.println(r);
            }
        }
        return maxRank;
    }

    private int getRank(int[][] adj, int n, int n1) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n1);
        boolean[] flag = new boolean[n];
        flag[n1] = true;
        int rank = 0;
        while (queue.size() > 0) {
            int cur = queue.poll();
            for (int i = 0; i < n; i++) {
                if (!flag[i] && adj[cur][i] == 1) {
                    ++rank;
                    flag[i] = true;
                }
            }
        }
        return rank;
    }
}