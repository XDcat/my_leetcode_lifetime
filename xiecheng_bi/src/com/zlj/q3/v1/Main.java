package com.zlj.q3.v1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int l = in.nextInt();
        int r = in.nextInt();
        // weight
        String weightString = in.next();
        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = (weightString.charAt(i) == '0') ? 0 : 1;
        }
        // tree
        int[][] adj = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            adj[a - 1][b - 1] = 1;
            adj[b - 1][a - 1] = 1;
        }
        Solution solution = new Solution();
        System.out.println(solution.solve(adj, weight, n, l, r));
    }
}

class Solution {
    int countVisited;
    int n, lo, hi;
    boolean[] visited;
    int[] weight;
    int[][] adj;

    public int solve(int[][] adj, int[] weight, int n, int lo, int hi) {
        // init
        countVisited = 0;
        visited = new boolean[n];
        this.n = n;
        this.lo = lo;
        this.hi = hi;
        this.adj = adj;
        this.weight = weight;
        // res
        int res = 0;
        // dfs
        for (int i = 0; i < n; i++) {
            res += dfs(i, 0);
        }
        return res;
    }

    private int dfs(int cur, int sum) {
        if (countVisited == n) {
            return 0;
        }
        int count = 0;
        countVisited++;
        visited[cur] = true;
        sum = (sum << 1) + weight[cur];
        if (countVisited > 1) {
            count += (sum >= lo && sum <= hi) ? 1 : 0;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i] && adj[cur][i] == 1) {
                count += dfs(i, sum);
            }
        }
        sum = sum - weight[cur] >> 1;
        visited[cur] = false;
        countVisited--;
        return count;
    }
}


