package com.zlj.q4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        Solution solution = new Solution();
        System.out.println(solution.solve(n, nums));
    }
}

class Solution {
    long mod = (long) (Math.pow(10, 9) + 7);
    public long solve(int n, int[] nums) {
        long res = 0;
        // single
        for (int num :
                nums) {
            long cur = (long) num * (num + 1) / 2;
            cur = cur % mod;
            res = (res + cur) % mod;
        }
        // multi
        for (int i = 0; i < n; i++) {
            for (int j = i + 2; j < n; j+=2) {
                // check valid
                for (int k = 0; k <= (j - i); k++) {
                    if (nums[i + k] != nums[j - k]){
                        break;
                    }
                }
                // valid
                res = (res + nums[i]) % mod;
            }
        }

        return res;
    }

}
