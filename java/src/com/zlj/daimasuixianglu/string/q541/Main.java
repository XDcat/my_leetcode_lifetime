package com.zlj.daimasuixianglu.string.q541;

/**
 * @author Lianjie Zeng <zenglianjie@foxmail.com>
 * Created on 2023-07-30
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseStr("abcdefg", 2));
    }
}

class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int lo = 0;
        while (lo + k - 1 < chars.length){
            reverse(chars, lo, lo + k - 1);
            lo = lo + 2 * k;
        }

        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int lo, int hi){
        for (int i = 0; i <= (hi - lo) / 2; i++){
            chars[lo + i] ^= chars[hi - i];
            chars[hi - i] ^= chars[lo + i];
            chars[lo + i] ^= chars[hi - i];
        }
    }
}
