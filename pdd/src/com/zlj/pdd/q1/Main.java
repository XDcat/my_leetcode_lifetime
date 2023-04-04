package com.zlj.pdd.q1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] rows = new int[n][2];
        for (int i = 0; i < n; i++) {
            String next = in.next();
            if (next.equals("b")) {
                rows[i][0] = in.nextInt();
                rows[i][1] = -1;
            } else {
                rows[i][0] = in.nextInt();
                rows[i][1] = in.nextInt();
            }
        }

        Solution s = new Solution();
        System.out.println(s.solve(rows, n, m));
    }
}


class Solution {
    public int solve(int[][] rows, int n, int m) {
        Map<int[], Integer> map = new HashMap<>();
        map.put(new int[m + 1], 0);
        for (int i = 0; i < n; i++) {
            int thing = rows[i][0];
            int price = rows[i][1];
            if (price == -1) {
                // get
                for (int[] ints : map.keySet()) {
                    ints[thing]++;
                }
            } else {
                // sell
                int max = 0;
                for (int[] key : map.keySet()) {
                    if (key[thing] > 0) {
                        max = Math.max(max, map.get(key) + price);
                    }
                }
                // map.put(new int[m + 1], max);
                putMax(map, max, m);
            }
        }
        int max = 0;
        for (Integer value : map.values()) {
            max = Math.max(max, value);
        }
        return max;
    }

    private void putMax(Map<int[], Integer> map, int max, int m){
        int[] t = new int[m + 1];
        int[] key = null;
        for (int[] ints : map.keySet()) {
            if (Arrays.equals(t, ints)){
                key = ints;
                break;
            }
        }
        if (key == null){
            map.put(t, max);
        } else {
            map.put(key,
                    Math.max(max, map.get(key))
                    );
        }

    }
}
