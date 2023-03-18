package com.zlj.graph.mintree;

import java.util.ArrayList;
import java.util.List;

public class Prim {
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
        Prim prim = new Prim();
        System.out.println(prim.generateMinTree(n, edge));
    }

    public int generateMinTree(int n, int[][] edge){
        // create graph
        int[][] adj = new int[n][n];  // 0-no link, >0 link
        for (int[] row: edge){
            int n1 = row[0] - 1;
            int n2 = row[1] - 1;
            int w = row[2];
            adj[n1][n2] = w;
            adj[n2][n1] = w;
        }

        // search
        List<Integer> res = new ArrayList<>();
        int[] status = new int[n];  // 0-free, 1-visited

        // add the init node
        res.add(0);
        status[0] = 1;
        int treeLength = 0;
        while (hasFreeNode(status)){
            // find the min edge of visited nodes
            int minNode = -1;
            int minWeight = Integer.MAX_VALUE;
            for (int cur :
                    res) {
                for (int nei = 0; nei < n; nei++) {
                    if (adj[cur][nei] > 0 && status[nei] == 0) {  // is neighbour, and not visited
                        if (adj[cur][nei] < minWeight){
                            minNode = nei;
                            minWeight = adj[cur][nei];
                        }
                    }
                }
            }
            res.add(minNode);
            status[minNode] = 1;
            treeLength += minWeight;
        }

        return treeLength;
    }

    private boolean hasFreeNode(int[] status){
        for (int i :
                status) {
            if (i == 0){
                return true;
            }
        }
        return false;
    }
}
