package com.zlj.leetcode.normal.q310.loopdfs;

import java.util.*;

class Solution {
    public static void main(String[] args) {
//        int n = 6;
//        int[][] edges = new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        int n = 4;
        int[][] edges = new int[][]{{1, 0}, {1, 2}, {1, 3}};
        Solution s = new Solution();
        System.out.println(s.findMinHeightTrees(n, edges));
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // init nodes
        List<Integer>[] nodes = new List[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int[] row : edges) {
            int a = row[0];
            int b = row[1];
            nodes[a].add(b);
            nodes[b].add(a);
        }

        // find the longest path
        // x -> y
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        int x = DFS(n, 0, nodes, parent);
        int y = DFS(n, x, nodes, parent);

        // find the path of x -> y
        List<Integer> longestPath = new ArrayList<>();
        parent[x] = -1;
        int i = y;
        while (parent[i] != -1){
            longestPath.add(i);
            i = parent[i];
        }
        longestPath.add(x);
        // System.out.printf("path: %s -> %s, %s\n", x, y, longestPath);
        // return
        int length = longestPath.size();
        List<Integer> res = new ArrayList<>();
        if (length % 2 == 0){
            // two node
            res.add(longestPath.get((length-1) / 2));
            res.add(longestPath.get(length / 2));
        } else{
            res.add(longestPath.get(length / 2));
        }

        return res;
    }

    /**
     * Find the longest node via BFS
     * @return the longest node
     */
    private int DFS(int n, int start, List<Integer>[] nodes, int[] parent) {
        // init distance
        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        distance[start] = 0;

        // init stack
        Deque<Integer> stack = new LinkedList<>();
        stack.offer(start);

        // dfs
        int cur = -1;
        int maxDistance = 0;
        int maxNode = start;
        while (stack.size() > 0){
            cur = stack.poll();
            for(int child: nodes[cur]){
                if (distance[child] == -1){
                    distance[child] = distance[cur] + 1;
                    parent[child] = cur;
                    stack.offer(child);
                    if (distance[child] > maxDistance){
                        maxDistance = distance[child];
                        maxNode = child;
                    }
                }
            }
        }
        return maxNode;
    }
}