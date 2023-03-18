package com.zlj.meituan.test01;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String s = "MPMPCPMCMDEFEGDEHINHKLIN";
        Map<Character, Integer> map1 = new HashMap<>();  // start -> end
        Map<Character, Integer> map2 = new HashMap<>();  // end -> start

        for (int i = 0; i < s.length(); i++) {
            map1.put(s.charAt(i), i);
            int j = s.length() - 1 - i;
            map2.put(s.charAt(j), j);
        }
        System.out.println(map1);
        System.out.println(map2);

        int i = 0;
        while (i < s.length()) {
            char cur = s.charAt(i);
            // is the head
            if (map2.get(cur) == i) {
                int end = map1.get(cur);
                boolean allSmaller = true;
                for (int j = i + 1; j < end; j++) {
                    if (map1.get(s.charAt(j)) > end) {
                        allSmaller = false;
                        break;
                    }
                }
                if (allSmaller) {
                    // add end to result
                    System.out.println(end - i + 1);
                    i = end + 1;
                    continue;
                }
            }
            ++i;
        }
    }
}
