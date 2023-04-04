package com.zlj.pdd.q3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        Solution s = new Solution();
        s.solve(nums, n);
    }
}

class Solution{
    public void solve(int[] nums, int n){
        long max = 1;
        int[] res = new int[]{-1, -1};
        int len = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j < n; j++) {
                int cur = 1;
                for (int k = i; k <=j; k++) {
                    cur *= nums[k];
                }
                if (cur > max){
                    max = cur;
                    len = j - i + 1;
                    res[0] = i;
                    res[1] = j;
                } else if (cur == max && (j - i + 1) > len){
                    res[0] = i;
                    res[1] = j;
                    len = j - i + 1;
                }
            }
        }
        if (res[0] == -1){
            res = new int[0];
            System.out.println();
        } else {
            System.out.println("" + res[0] + " " + res[1]);
        }
    }
}
