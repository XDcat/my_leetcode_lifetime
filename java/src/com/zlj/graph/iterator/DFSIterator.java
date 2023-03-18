package com.zlj.graph.iterator;

import java.util.*;

public class DFSIterator {
    public static void main(String[] args) {
        int n = 10;
        int[][] edge = new int[][]{{1, 2}, {1, 3}, {2, 4}, {2, 5}, {4, 8}, {5, 8}, {3, 6}, {3, 7}, {6, 7}, {9,10}};
        DFSIterator bfs = new DFSIterator();
        System.out.println(bfs.DFS(n, edge));
    }
    public List<Integer> DFS(int n, int[][] edge){
        // create graph
        int[][] adj = new int[n][n];
        for (int[] row: edge){
            int n1 = row[0] - 1;
            int n2 = row[1] - 1;
            adj[n1][n2] = 1;
            adj[n2][n1] = 1;
        }

        // BFS
        List<Integer> res = new ArrayList<>();
        Deque<Integer> stack = new LinkedList<>();
        int[] status = new int[n];  // 0 - free, 1 - visited
        for (int start = 0; start < n; start++) {
            if (status[start] == 0){
                stack.push(start);
                while (stack.size() > 0){
                    int cur = stack.pop();
                    if (status[cur] == 1){
                        continue;
                    }
                    res.add(cur);
                    status[cur] = 1;
                    for (int i = n-1; i >=0; i--) {
                        if (adj[cur][i] == 1 && status[i] == 0){
                            stack.push(i);
                        }
                    }
                }
            }
        }

        // pre-process
        for (int i = 0; i < res.size(); i++) {
            res.set(i, res.get(i) + 1);
        }
        return res;
    }
}
