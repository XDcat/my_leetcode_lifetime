package com.zlj.leetcode.offerjianzhi;

import java.util.*;

public class Q2NumberString {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
//        System.out.println(s.isNumber("3."));
        System.out.println(s.isNumber("-1E-16"));
    }
    static class Solution {
        private char startNum = '0';
        private char endNum = '9';
        public boolean isNumber(String s) {
            // remove spaces
            s = s.trim();
            if (s.length() == 0){
                return false;
            }

            // check +-
            if (s.charAt(0) == '-' || s.charAt(0) == '+'){
                s = s.substring(1);
            }

            // find e
            int eIndex = Math.max(s.indexOf('e'), s.indexOf('E'));
            if (eIndex == -1){
                // no e
                return isFloat(s) || isInt(s);
            } else {
                // has e

                // invalid e
                if (eIndex == 0 || eIndex == s.length() - 1){
                    return false;
                }

                // check left and right
                boolean eLeft = isFloat(s.substring(0, eIndex)) || isInt(s.substring(0, eIndex));
                boolean eRight = isInt(s.substring(eIndex + 1));
                if (s.charAt(eIndex + 1) == '-' || s.charAt(eIndex + 1) == '+' && s.length() - eIndex >= 2){
                    eRight |= isInt(s.substring(eIndex + 2));
                }
                return eLeft && eRight;
            }

        }

        private boolean isInt(String s){
            if (s.length() == 0){
                return false;
            }

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c < startNum || c > endNum){
                    return false;
                }
            }
            return true;
        }

        private boolean isFloat(String s){
            // find dot
            int dotIndex = s.indexOf('.');

            // cant find or only one char
            if (dotIndex == -1 || s.length() == 1){
                return false;
            }

            // check left and right
            boolean left = s.substring(0, dotIndex).length() == 0 || isInt(s.substring(0, dotIndex));
            boolean right = s.substring(dotIndex + 1).length() == 0 || isInt(s.substring(dotIndex + 1));
            return left & right;
        }
    }
    static class Solution1 {
        public boolean isNumber(String s) {
            // init states
            Map<Character, Integer>[] states = new HashMap[10];
            states[0] = new HashMap<>(){{ put(' ', 0); put('d', 2); put('.', 4); put('s', 1);}};
            states[1] = new HashMap<>(){{put('d', 2); put('.', 4);}};
            states[2] = new HashMap<>(){{put(' ', 9); put('d', 2); put('.', 3);put('e', 6);}};
            states[3] = new HashMap<>(){{put(' ', 9); put('d', 5); put('e', 6);}};
            states[4] = new HashMap<>(){{put('d', 5);}};
            states[5] = new HashMap<>(){{put('d', 5); put('e', 6); put(' ', 9);}};
            states[6] = new HashMap<>(){{put('s', 7); put('d', 8);}};
            states[7] = new HashMap<>(){{put('d', 8);}};
            states[8] = new HashMap<>(){{put(' ', 9); put('d', 8);}};
            states[9] = new HashMap<>(){{put(' ', 9);}};

            int curState = 0;
            char curChar;
            for(char c: s.toCharArray()){
                if (c >= '0' && c <= '9') {
                    curChar = 'd';
                }else if(c == '-' || c == '+'){
                    curChar = 's';
                } else if (c == 'e' || c == 'E'){
                    curChar = 'e';
                } else if (c == ' ' || c == '.'){
                    curChar = c;
                } else {
                    curChar = '?';
                }

                if (!states[curState].containsKey(curChar)){
                    return false;
                }
                curState = states[curState].get(curChar);
            }

            List<Integer> successStates = List.of(2, 3, 5, 8, 9);
            return successStates.contains(curState);
        }
    }
}
