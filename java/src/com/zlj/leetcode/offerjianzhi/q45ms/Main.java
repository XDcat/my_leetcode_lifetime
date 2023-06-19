package com.zlj.leetcode.offerjianzhi.q45ms;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minNumber(new int[]{3,30,34,5,9}));
    }
}
class Solution {
    public String minNumber(int[] nums) {
        String[] strs = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder builder = new StringBuilder();
        for (String s :
                strs) {
            builder.append(s);
        }
        return builder.toString();
    }
}
