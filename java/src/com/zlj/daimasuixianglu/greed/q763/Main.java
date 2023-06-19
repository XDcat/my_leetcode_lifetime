package com.zlj.daimasuixianglu.greed.q763;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        Solution solution = new Solution();
        System.out.println(solution.partitionLabels(s));
    }
}


class Solution {
    public List<Integer> partitionLabels(String s) {
        // find range
        int[] edge = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            edge[c] = i;
        }

        // find
        List<Integer> res = new ArrayList<>();
        int start = 0;
        int end = -1;

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            end = Math.max(end, edge[c]);
            if (end == i) {
                res.add(end - start + 1);
                start = i + 1;
            }
        }

        return res;
    }
}
