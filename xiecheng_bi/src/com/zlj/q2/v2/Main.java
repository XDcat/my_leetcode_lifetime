package com.zlj.q2.v2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Solution solution = new Solution();
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            long n = in.nextLong();
            solution.solve(n);
        }
//        System.out.println(Solution.maxYue(15, 30));
    }
}

class Solution {
    public void solve(long n) {
        long res1 = 1, res2 = n - res1;
        long max = res2;
        for (long i = 1; i <= n / 2; i++) {
            long a = i;
            long b = n - a;
            long t = (long) a * b / maxYue(a, b);
            if (t > max) {
                res1 = a;
                res2 = b;
            }
        }
        System.out.println("" + res1 + " " + res2);
    }

    public static long maxYue(long a, long b) {
        if (a < b) {
            long t = a;
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
