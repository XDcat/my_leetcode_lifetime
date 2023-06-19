package com.zlj.q2.v1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Solution solution = new Solution();
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            solution.solve(n);
        }
//        System.out.println(Solution.maxYue(15, 30));
    }
}

class Solution {
    public void solve(int n) {
        int res1 = 1, res2 = n - res1;
        long max = res2;
        for (int i = 1; i <= n / 2; i++) {
            int a = i;
            int b = n - a;
            long t = (long) a * b / maxYue(a, b);
            if (t > max) {
                res1 = a;
                res2 = b;
            }
        }
        System.out.println("" + res1 + " " + res2);
    }

    public static int maxYue(int a, int b) {
        if (a < b) {
            int t = a;
            a = b;
            b = t;
        }
        if (a % b == 0) {
            return b;
        } else {
            return maxYue(a % b, b);
        }
    }
}
