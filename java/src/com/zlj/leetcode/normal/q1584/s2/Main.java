package com.zlj.leetcode.normal.q1584.s2;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Lianjie Zeng <zenglianjie@foxmail.com>
 * Created on 2023-08-18
 */
public class Main {

}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[][] graph = new int[n][n];
        for (int i = 0; i < points.length; i++) {
            for (int j = i  + 1; j < points.length; j++) {
                int d = Math.abs(points[i][0] - points[j][0]) +  Math.abs(points[i][1] - points[j][1]);
                graph[i][j] = d;
                graph[j][i] = d;
            }
        }

        // kru
        boolean[] visited = new boolean[n];
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        heap.offer(new int[]{0, 0});
        int res = 0;

        while (heap.size() > 0){
            int[] cur = heap.poll();
            int n1 = cur[0], d1 = cur[1];
            if (visited[n1]) continue;
            visited[n1] = true;
            res += d1;

            for (int i = 0; i < n; i++) {
                if (graph[n1][i] > 0){
                    heap.offer(new int[]{i, graph[n1][i]});
                }
            }
        }
        return res;
    }
}
