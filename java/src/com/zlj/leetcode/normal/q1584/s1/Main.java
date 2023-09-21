package com.zlj.leetcode.normal.q1584.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lianjie Zeng <zenglianjie@foxmail.com>
 * Created on 2023-08-18
 */
public class Main {

}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i  + 1; j < points.length; j++) {
                int d = Math.abs(points[i][0] - points[j][0]) +  Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{i, j, d});
            }
        }
        edges.sort((a, b) -> a[2] - b[2]);

        // UF
        int n = points.length;
        int[] id = new int[n];
        for (int i = 0; i < n; i++){
            id[i] = i;
        }

        int res = 0;
        for (int[] edge : edges) {
            int n1 = edge[0], n2 = edge[1], n3 = edge[2];
            if (id[n1] != id[n2]){
                // union
                int t = id[n2];
                for (int i = 0; i < n; i++) {
                    if (id[i] == t){
                        id[i] = id[n1];
                    }
                }
                res += n3;
            }
        }
        return res;
    }
}
