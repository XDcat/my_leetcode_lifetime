package com.zlj.daimasuixianglu.tree.q310;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Lianjie Zeng <zenglianjie@foxmail.com>
 * Created on 2023-08-06
 */
public class Main {
}


class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // build graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] row: edges){
            int i = row[0];
            int j = row[1];
            graph.get(i).add(j);
            graph.get(j).add(i);
        }

        // find x
        int[] parent = new int[n];
        int x = bfs(0, graph, parent, n);

        // find y
        int y = bfs(x, graph, parent, n);

        // find the result
        List<Integer> path = new ArrayList<>();
        parent[x] = -1;
        while (y != -1){
            path.add(y);
            y = parent[y];
        }

        // generate result
        List<Integer> res = new ArrayList<>();
        if (path.size() % 2 == 1){
            res.add(path.get(path.size() / 2));
        } else {
            res.add(path.get(path.size() / 2));
            res.add(path.get(path.size() / 2 - 1));
        }
        return res;
    }

    /* 寻找 graph 中 距离 root 最远的节点 */
    private int bfs(int root, List<List<Integer>> graph, int[] parent, int n){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        visited[root] = true;
        queue.offer(root);

        int node = -1;
        while (queue.size() > 0){
            for (int i = queue.size(); i > 0; i--){
                node = queue.poll();
                for (int child: graph.get(node)){
                    if (visited[child] == false){
                        queue.offer(child);
                        parent[child] = node;
                        visited[child] = true;
                    }
                }
            }
        }

        return node;
    }
}


