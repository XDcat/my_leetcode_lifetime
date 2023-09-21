package com.zlj.kmp.exercise.t3;

import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getNext("abcabcabc")));
    }
    private static int[] getNext(String str){
        int[] next = new int[str.length()];
        int j = 0;
        for (int i = 1; i < str.length(); i++){
            while (j > 0 && str.charAt(i) != str.charAt(j)){
                j = next[j - 1];
            }

            if (str.charAt(i) == str.charAt(j)){
                j++;
            }
            next[i] = j;
        }

        return next;
    }

}
