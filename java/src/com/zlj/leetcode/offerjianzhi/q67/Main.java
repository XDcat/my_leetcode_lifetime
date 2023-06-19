package com.zlj.leetcode.offerjianzhi.q67;

import javax.security.auth.callback.CallbackHandler;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strToInt("        112469032d53"));
    }

}
class Solution {
    private Map<Character, Integer>[] table;

    public Solution() {
        table = new HashMap[4];
        table[0] = new HashMap<Character, Integer>(){{put(' ', 0); put('-', 1); put('d', 2); put('+', 3);}};
        table[1] = new HashMap<Character, Integer>(){{put('d', 2);}};
        table[2] = new HashMap<Character, Integer>(){{put('d', 2);}};
        table[3] = new HashMap<Character, Integer>(){{put('d', 2);}};
    }

    public int strToInt(String str) {
        int status = 0;
        int res = 0;
        int sign = 1;
        int bndry = Integer.MAX_VALUE / 10;
        for (char c :
                str.toCharArray()) {
            char curStatus = c;
            if (c >= '0' && c <= '9'){
                curStatus = 'd';
            }
            if (c == 'd'){
                curStatus = 'D';
            }

            if (table[status].containsKey(curStatus)){
                status = table[status].get(curStatus);
                if (curStatus == '-'){
                    sign = -1;
                } else if(curStatus == '+'){
                    continue;
                } else if (curStatus == 'd'){
                    if ((res > bndry) || (res == bndry && c >'7')){
                        return (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    }
                    res = res * 10 + (c - '0');
                }
            } else {
                break;
            }
        }

        res = res * sign;
        return res;
    }
}
