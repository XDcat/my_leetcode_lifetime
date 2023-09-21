package com.zlj.datestructure.rbt;

/**
 * @author Lianjie Zeng <zenglianjie@foxmail.com>
 * Created on 2023-08-30
 */
public class Main {
    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();
        rbt.put(1, 10);
        rbt.display();
        rbt.put(2, 3);
        rbt.put(9, 8);
        rbt.put(5, 4);
        rbt.put(4, 4);
        rbt.display();
        rbt.put(1, 1);
        rbt.display();

    }
}

class RedBlackTree{
    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    class Node {
        Node left, right;
        int key;
        int value;
        int N;  // 子节点个数
        boolean color;

        public Node(int key, int value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
            N = 1;
        }

    }
    private boolean isRed(Node node){
        if (node == null) return false;
        return node.color == RED;
    }
    private Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;

        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;

        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private void flipColor(Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public void put(int key, int value){
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node h, int key, int value){
        if (h == null){
            return new Node(key, value, RED);
        }

        int cmp = h.key - key;
        if (cmp < 0){
            h.right = put(h.right, key, value);
        } else if (cmp > 0){
            h.left = put(h.left, key, value);
        } else {
            h.value = value;
        }

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColor(h);

        h.N = 1 + size(h.left) + size(h.right);
        return h;
    }
    public int size(){
        return size(root);
    }
    public int size(Node h){
        if (h == null) return 0;
        else return h.N;
    }

    public void display(){
        System.out.println("------");
        display(root);
        System.out.println("------");
    }
    private void display(Node h){
        if (h == null) return;
        display(h.left);
        System.out.printf("%s: %s, size=%s\n", h.key, h.value, h.N);
        display(h.right);
    }
}

