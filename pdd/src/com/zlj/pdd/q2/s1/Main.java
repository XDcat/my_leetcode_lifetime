package com.zlj.pdd.q2.s1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] adj = new int[n][n];
        for (int[] ints : adj) {
            Arrays.fill(ints, -1);
        }

        for (int i = 0; i < n - 1; i++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            int c = in.nextInt();
            adj[a][b] = c;
            adj[b][a] = c;
        }
        // System.out.println(Arrays.deepToString(adj));
        Solution s = new Solution();
        System.out.println(s.solve(adj, n));
    }
}

class Solution {
    boolean[] flag;
    public int solve(int[][] adj, int n) {
        // BFS
//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(0);
        flag = new boolean[n];
        return dfs(adj, 0);
    }

    private int dfs(int[][] adj, int cur) {
        int[] nei = adj[cur];
        int count = 0;
        flag[cur] = true;
        boolean hasLine = false;
        for (int i = 0; i < nei.length; i++) {
            if (nei[i] != -1 && ! flag[i]) {
                count += dfs(adj, i);
                if (nei[i] == 1) {
                    count++;
                    hasLine = true;
                }
            }
        }
        if (hasLine && count > 1){
            count --;
        }
        return count;
    }
}
