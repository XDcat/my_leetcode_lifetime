package com.zlj.kmp.exercise.t2;

public class Main {
    public static void main(String[] args) {
        KMP kmp = new KMP();
        System.out.println(kmp.kmp("aaababac", "abac"));
    }
}

class KMP{
    public int kmp(String str, String sub){
        int[] next = getNext(sub);
        int M = str.length(), N = sub.length();
        int i = 0, j = 0;
        while (i < M && j < N){
            while (j > 0 && str.charAt(i) != sub.charAt(j)){
                j = next[j - 1];
            }

            if (str.charAt(i) == sub.charAt(j)){
                j++;
            }
            i++;
        }

        if (j == N){
            return i - N;
        } else {
            return -1;
        }
    }

    private int[] getNext(String str){
        int[] next = new int[str.length()];
        int j = 0;
        for (int i = 1; i < next.length; i++) {
            while (j > 0 && str.charAt(j) != str.charAt(i)){
                j = next[j - 1];
            }

            if (str.charAt(j) == str.charAt(i)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
