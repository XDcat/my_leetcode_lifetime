package com.zlj.baidu.q3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Node root = Node.generateTree();
    }
}

class Node {
    private Node left, right;  // children
    private boolean isRed;
    private int ir, br;  // color count
    private int val;

    public Node(boolean isRed, int v) {
        this.isRed = isRed;
        this.val = v;
    }

    public static Node generateTree() {
        // input
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String color = in.next();
        Node[] nodes = new Node[n + 1];
        for (int i = 0; i < n; i++) {
            boolean isRed = color.charAt(i) == 'r';
            nodes[i + 1] = new Node(isRed, i + 1);
        }
        // input edge
        boolean[][] table = new boolean[n + 1][n + 1];
        for (int i = 0; i < n - 1; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            table[a][b] = true;
            table[b][a] = true;
        }

        // find root which link 1 or 2 node
        int rootIndex = -1;
        for (int i = 1; i < n; i++) {
            int s = 0;
            for (int j = 1; j < n; j++) {
                s += table[i][j] ? 1 : 0;
            }
            if (s < 3) {
                rootIndex = i;
                break;
            }
        }

        // construct tree
        createNode(nodes, table, rootIndex);
        Node root = nodes[rootIndex];
        return root;
    }

    private static void createNode(Node[] nodes, boolean[][] table, int rootIndex) {
        Node root = nodes[rootIndex];
        for (int i = 1; i < nodes.length; i++) {
            if (table[rootIndex][i]) {
                if (root.left == null) {
                    root.left = nodes[i];
                } else {
                    root.right = nodes[i];
                }
                table[rootIndex][i] = false;
                table[i][rootIndex] = false;
                createNode(nodes, table, i);
            }
        }
    }
}
