package com.zlj.leetcode.normal.q743;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Lianjie Zeng <zenglianjie@foxmail.com>
 * Created on 2023-08-17
 */
public class Main {
    public static void main(String[] args) {
        int[][] times = new int[][]{
                // {2,1,1},{2,3,1},{3,4,1}
                {1,2,1}
        };
        Solution solution = new Solution();
        System.out.println(solution.networkDelayTime(times, 2, 2));
    }
}


class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++){
            g.add(new ArrayList<>());
        }
        for (int[] row: times){
            g.get(row[0]).add(new int[]{row[1], row[2]});
            // g.get(row[1]).add(new int[]{row[0], row[2]});
        }

        // dij
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visit = new boolean[n + 1];
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        heap.offer(new int[]{k, 0});
        dist[k] = 0;

        while (heap.size() > 0){
            int[] cur = heap.poll();
            int x = cur[0], time = cur[1];
            if (visit[x]) continue;
            visit[x] = true;
            for (int[] nei : g.get(cur[0])) {
                int y = nei[0], d = time + nei[1];
                if (dist[y] > d){
                    dist[y] = d;
                    heap.offer(new int[]{y, d});
                }
            }
        }

        // res
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dist[i]);
        }
        return (res == Integer.MAX_VALUE)? -1: res;
    }
}
