package com.zlj.leetcode.offerjianzhi.q13mst.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.movingCount(2, 3, 1));
        System.out.println(Arrays.deepToString(solution.visited));
    }
}

class Solution {
    boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, 0});
        int count = 0;
        while (queue.size() > 0){
            int[] cur = queue.poll();
            int i = cur[0], j = cur[1], si = cur[2], sj = cur[3];
            if (i >= m || j >=n || si + sj > k || visited[i][j]){
                continue;
            }
            visited[i][j] = true;
            count++;
            queue.offer(new int[]{i + 1, j, ((i + 1) % 10 == 0)? si - 8: si + 1, sj});
            queue.offer(new int[]{i, j + 1, si, ((j + 1) % 10 == 0)? sj - 8: sj + 1});
        }
        return count;
    }
}
