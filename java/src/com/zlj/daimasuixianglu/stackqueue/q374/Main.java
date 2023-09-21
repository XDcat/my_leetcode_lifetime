package com.zlj.daimasuixianglu.stackqueue.q374;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Lianjie Zeng <zenglianjie@foxmail.com>
 * Created on 2023-08-01
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // count
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // build heap
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        map.forEach((a, b) -> {
            heap.offer(new int[]{a, b});
        });

        // find res
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll()[0];
        }
        return res;
    }
}