package com.zlj.leetcode.normal.q210;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.findOrder(3, new int[][]{
                {1, 0}, {1, 2}, {0, 1}
        });
        System.out.println(Arrays.toString(res));
    }
}

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites){
        int[] res = new int[numCourses];
        int[] emptyRes = new int[0];
        // create graph, cal in-degree
        int[][] adj = new int[numCourses][numCourses];
        int[] in = new int[numCourses];
        for (int[] row :
                prerequisites) {
            int a = row[0];
            int b = row[1];
            adj[b][a] = 1;
            in[a]++;
        }

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        // add start node
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                queue.offer(i);
            }
        }
        // System.out.println("in" + Arrays.toString(in));
        // search
        int visited = 0;
        while (queue.size() != 0) {
            int cur = queue.poll();
            res[visited] = cur;
            visited++;
            // System.out.printf("cur is %s, in is %s\n", cur, in[cur]);
            if (in[cur] != 0) {
                return emptyRes;
            }
            for (int i = 0; i < numCourses; i++) {
                if (adj[cur][i] == 1) {
                    in[i]--;
                    if (in[i] == 0){
                        queue.offer(i);
                    }
                }
            }
        }

        // check again
        return (visited == numCourses)? res : emptyRes;
    }
}
