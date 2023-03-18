package com.zlj.baidu.q2;

import java.util.Scanner;

public class Main {
    private static final char[] words = {'r', 'e', 'd'};
    public static void main(String[] args) {
        // input
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();

        // solve
        // find target n
        int n = 1;
        while (n * (n + 1) / 2 <= x) {
            n++;
        }
        n = n - 1;

        // get n
        StringBuilder builder = new StringBuilder();
        int wordIndex = 0;
        while (x > 0){
            // Add words
            for (int i = 0; i < n; i++) {
                builder.append(words[wordIndex]);
            }
            wordIndex = (wordIndex + 1) % 3;

            // System.out.println(n);
            x = x - (n * (n + 1) / 2);

            // update x
            while (n > 0 && n * (n + 1) / 2 > x){
                n --;
            }
        }
        System.out.println(builder.toString());
    }
}
