package com.zlj.daimasuixianglu.backtrack.q93;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.restoreIpAddresses("25525511135"));
    }
}
class Solution {
    List<String> res;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        String[] path = new String[4];
        backtrack(s, path, 0);
        return res;
    }

    private void backtrack(String s, String[] path, int idx){
        if (idx == 4 && s.length() == 0){
            res.add(String.join(".", path));
            return;
        }

        int len = (s.charAt(0) == '0')? 1: 3;
        len = Math.min(len, s.length());
        for (int i = 0; i < len; i++){
            String sub = s.substring(0, i + 1);
            if (Integer.parseInt(sub) <= 255 && s.length() - i - 1 >= 4 - idx - 1 && s.length() - i - 1 <= (4 - idx - 1) * 3){
                path[idx] = sub;
                backtrack(s.substring(i+1), path, idx+1);
            }
        }
    }
}