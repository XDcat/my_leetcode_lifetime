package com.zlj.baidu.q1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private static  final Set<Character> set1 = generateSet("Baidu");
    private static  final int N = 5;

    public static void main(String[] args) {
        // input
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String s = in.next();
            System.out.println(solve(s));
        }

    }

    private static String solve(String s) {
        if (s.length() != N){
            return "No";
        }
        Set<Character> set2 = generateSet(s);
        return set1.equals(set2)? "Yes": "No";
    }

    private static Set<Character> generateSet(String s){
        Set<Character> set = new HashSet<>();
        for (Character c:
             s.toCharArray()) {
            set.add(c);
        }
        return set;
    }
}
