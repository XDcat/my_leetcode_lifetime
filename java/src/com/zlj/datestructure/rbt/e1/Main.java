package com.zlj.datestructure.rbt.e1;

/**
 * @author Lianjie Zeng <zenglianjie@foxmail.com>
 * Created on 2023-08-30
 */
public class Main {
    public static void main(String[] args) {
        String str = "Hello World";
        RedBlackTree<Character, Integer> rbt = new RedBlackTree<>();
        for (char c : str.toCharArray()) {
            Integer pre = rbt.get(c);
            if (pre == null){
                rbt.put(c, 1);
            } else {
                rbt.put(c, pre + 1);
            }
        }
        rbt.display();
    }
}

class RedBlackTree <Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private class Node{
        private Node left, right;
        private Key key;
        private Value value;
        private boolean color;
        private int N;

        public Node(Key key, Value value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
            N = 1;
        }
    }

    private Node root;
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

    private Node rotationRight(Node h){
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
        h.left.color = BLACK;
        h.right.color = BLACK;
        h.color = RED;
    }
    private boolean isRed(Node h){
        if (h == null) return BLACK;
        return h.color == RED;
    }

    public int size(){
        return size(root);
    }
    private int size(Node h){
        if (h == null) return 0;
        else return h.N;
    }

    public void put(Key k, Value v){
        root = put(root, k, v);
        root.color = BLACK;
    }

    private Node put(Node h, Key k, Value v){
        if (h == null) return new Node(k, v, RED);

        int cmp = h.key.compareTo(k);
        if (cmp < 0) h.right = put(h.right, k, v);
        else if (cmp > 0) h.left = put(h.left, k, v);
        else h.value = v;

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left))  h = rotationRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColor(h);

        h.N = 1 + size(h.left) + size(h.right);
        return h;
    }

    public Value get(Key k){
        return get(root, k);
    }

    public Value get(Node h, Key k){
        if (h == null) return null;
        int cmp = h.key.compareTo(k);
        if (cmp < 0) return get(h.right, k);
        else if (cmp > 0) return get(h.left, k);
        return h.value;
    }

    public void display(){
        System.out.println("-------");
        display(root);
        System.out.println("-------");
    }
    private void display(Node h){
        if (h == null) return;

        display(h.left);
        System.out.printf("%s: %s, size is %s, isRed %s, count black (%s, %s)\n", h.key, h.value, size(h), isRed(h), countBlack(h.left), countBlack(h.right));
        display(h.right);
    }

    private int countBlack(Node h){
        if (h == null) return 0;
        int res = (h.color == BLACK)? 1 : 0;
        res += countBlack(h.left) + countBlack(h.right);
        return res;
    }
}
