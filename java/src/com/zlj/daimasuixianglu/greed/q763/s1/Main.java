package com.zlj.daimasuixianglu.greed.q763.s1;

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
        int[] left = new int[26];
        int[] right = new int[26];
        Arrays.fill(left, Integer.MAX_VALUE);
        Arrays.fill(right, -1);
        for (int i = 0; i < s.length(); i++){
            int c = s.charAt(i) - 'a';
            left[c] = Math.min(i, left[c]);
            right[c] = i;
        }

        // find
        List<Integer> res = new ArrayList<>();
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++){
            int c = s.charAt(i) - 'a';
            if (left[c] < end){
                // overlap
                end = Math.max(end, right[c]);
            } else {
                res.add(end - start + 1);
                start = i;
                end = right[c];
            }
        }

        res.add(end - start + 1);
        res.remove(0);
        return res;
    }
}
