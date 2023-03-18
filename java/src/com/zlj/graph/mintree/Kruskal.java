package com.zlj.graph.mintree;

import java.util.*;

public class Kruskal {
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = new int[][]{
                {1, 2, 6},
                {1, 3, 1},
                {1, 4, 5},
                {2, 3, 5},
                {2, 5, 3},
                {3, 4, 5},
                {3, 5, 6},
                {3, 6, 4},
                {4, 6, 2},
                {5, 6, 6}
        };
        Kruskal prim = new Kruskal();
        System.out.println(prim.generateMinTree(n, edge));
    }

    public int generateMinTree(int n, int[][] edge) {
        int[] status = new int[n];
        for (int i = 0; i < n; i++) {
            status[i] = i;
        }

        List<int[]> edges = Arrays.asList(edge);
        edges.sort(Comparator.comparingInt((int[] a) -> a[2]));
        int minTreeLength = 0;
        for (int[] row :
                edges) {
            int n1 = row[0]-1;
            int n2 = row[1]-1;
            int w = row[2];
            if (status[n1] != status[n2]){
                // not a ring -> add
                // n2 add to n1
                int n2Status = status[n2];
                for (int i = 0; i < n; i++) {
                    if (status[i] == n2Status){
                        status[i] = status[n1];
                    }
                }

                minTreeLength += w;
                System.out.printf("Add %s-%s, weight=%s\n", n1, n2, w);
            }

        }
        return minTreeLength;
    }

}
