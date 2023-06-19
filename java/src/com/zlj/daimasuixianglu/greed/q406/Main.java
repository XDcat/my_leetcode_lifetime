package com.zlj.daimasuixianglu.greed.q406;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] people = {
                {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}
        };
        System.out.println(Arrays.deepToString(solution.reconstructQueue(people)));
    }
}
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            else return a[1] - b[1];
        });

        // find
        List<int[]> list = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            int k = people[i][1];
            list.add(k, people[i]);
        }

        return list.toArray(new int[list.size()][]);
    }
}
