package com.zlj.interview.q1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        in.nextLine();
        String str = in.nextLine();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i % (k + 1) != 0){
                builder.append(str.charAt(i));
            }
        }
        System.out.println(builder.toString());
    }
}
