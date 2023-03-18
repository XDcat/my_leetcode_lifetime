package com.zlj.graph.iterator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSIterator {
    public static void main(String[] args) {
        int n = 9;
        int[][] edge = new int[][]{{1, 2}, {1, 3}, {2, 4}, {2, 5}, {4, 8}, {5, 8}, {3, 6}, {3, 7}, {6, 7}};
        BFSIterator bfs = new BFSIterator();
        System.out.println(bfs.BFS(n, edge));
    }
    public List<Integer> BFS(int n, int[][] edge){
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
        Queue<Integer> queue = new LinkedList<>();
        int[] status = new int[n];  // 0 - free, 1 - waited, 2 - visited
        for (int start = 0; start < n; start++) {
            if (status[start] == 0){
                queue.offer(start);
                status[start] = 1;
                while (queue.size() > 0){
                    int cur = queue.poll();
                    res.add(cur);
                    status[cur] = 2;
                    for (int i = 0; i < n; i++) {
                        if (adj[cur][i] == 1 && status[i] == 0){  // reachable and free
                            queue.offer(i);
                            status[i] = 1;
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
