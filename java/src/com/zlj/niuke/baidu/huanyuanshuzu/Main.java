package com.zlj.niuke.baidu.huanyuanshuzu;

import java.util.Arrays;
import java.util.Scanner;


import java.util.Arrays;
        import java.util.Collections;
        import java.util.PriorityQueue;
        import java.util.Queue;
        import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int N = in.nextInt();
        long[] nums = new long[N];
        for (int i = 0; i < N; i++){
            nums[i] = in.nextLong();
        }

        System.out.println("Start program");
        Solve s = new Solve();
        long res = s.solve(nums);
        System.out.println(res);
    }
}

class Solve{
    public long solve(long[] nums){
        // heap sort
        int N = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < N / 2 ; i ++){
            swap(nums, i, N - 1 - i);
        }
        // System.out.prlongln(Arrays.toString(nums));
        // loop
        int count = 0;
        while (nums[0] >= N){
            nums[0] = nums[0] - N;
            for (int i = 1; i < N; i++){
                nums[i] += 1;
            }
            sink(nums, 0, N - 1);
            count ++;
             System.out.println(Arrays.toString(nums));
        }

        return count;
    }

    private void sink(long[] nums, int lo, int hi){
        // from top to down, top is the bigger one
        int i = lo;
        while (2 * i + 1 <= hi){
            int j = 2 * i + 1;
            if (j + 1 <= hi && nums[j+1] > nums[j]){
                j++;
            }

            if (nums[i] > nums[j]){
                break;
            }

            swap(nums, i, j);
            i = j;
        }

    }

    private void swap(long[] nums, int i, int j){
        long t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}