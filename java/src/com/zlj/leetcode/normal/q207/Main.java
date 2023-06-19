package com.zlj.leetcode.normal.q207;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.canFinish(3, new int[][]{
                {1, 0}, {1, 2}, {0, 1}
        });
        System.out.println(res);
    }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // create graph, cal in-degree
        int[][] adj = new int[numCourses][numCourses];
        int[] in = new int[numCourses];
        for (int[] row :
                prerequisites) {
            int a = row[0];
            int b = row[1];
            if (a == b){
                return false;
            }
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
        if (queue.size() == 0) {
            return false;
        }
        System.out.println("in" + Arrays.toString(in));
        // search
        int visited = 0;
        while (queue.size() != 0) {
            int cur = queue.poll();
            visited++;
            System.out.printf("cur is %s, in is %s\n", cur, in[cur]);
            if (in[cur] != 0) {
                return false;
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
        return visited == numCourses;
    }
}
