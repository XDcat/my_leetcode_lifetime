package com.zlj.leetcode.normal.q1834;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int[][] tasks = new int[][]{{1, 2}, {2, 4}, {3, 2}, {4, 1}};
        Solution solution = new Solution();
        int[] order = solution.getOrder(tasks);
        System.out.println(Arrays.toString(order));
    }
}

class Solution {
    /**
     * Use to DS to save:
     * 1. array -> tasks ordered by start time
     * 2. priority queue -> tasks which satisfied cur time
     */
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        // create a new array to save tasks and index
        // if not, need to use many loop to find the tasks
        int[][] seq = new int[n][3];  // tasks sorted
        for (int i = 0; i < n; i++) {
            seq[i][0] = tasks[i][0];  // start time
            seq[i][1] = tasks[i][1];  // running time
            seq[i][2] = i;            // index
        }
        Arrays.sort(seq, (x, y) -> x[0] - y[0]);

        // priority queue to keep tasks with running time
        Queue<int[]> queue = new PriorityQueue<int[]>((x, y) -> {
            if (x[1] == y[1]) {
                return x[2] - y[2];
            } else {
                return x[1] - y[1];
            }
        });

        // loop
        int curTime = seq[0][0];
        int[] res = new int[n];
        for (int i = 0, j = 0; i < n;) {
            // put tasks
            while (j < n && seq[j][0] <= curTime) {
                queue.offer(seq[j++]);
            }
            // choose task
            if (queue.size() == 0) {
                curTime = seq[j][0];
            } else {
                int[] tmp = queue.poll();
                res[i++] = tmp[2];
                curTime += tmp[1];
            }
        }
        return res;
    }
}
