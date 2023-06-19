package com.zlj.daimasuixianglu.backtrack.q131;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.partition("aab"));

        String[] lst = new String[]{"111", "222", "11", "33"};
        System.out.println(String.join(".", lst));
    }
}

class Solution {
    private List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        partition(s, path);
        return res;
    }

    private void partition(String s, List<String> path){
        if (s.length() == 0) {
            res.add(new ArrayList<String>(path));
        };

        for (int i = 0; i < s.length(); i++){
            String sub = s.substring(0, i + 1);
            if (isValid(sub)){
                path.add(sub);
                partition(s.substring(i + 1), path);
                path.remove(path.size() - 1);
            }
        }

    }

    private boolean isValid(String s){
        boolean res = true;
        for (int i = 0; i < s.length() / 2; i++){
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)){
                res = false;
                break;
            }
        }

        return res;
    }

}
