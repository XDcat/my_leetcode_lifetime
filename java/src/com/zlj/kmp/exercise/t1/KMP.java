package com.zlj.kmp.exercise.t1;

public class KMP {
    public static void main(String[] args) {
        KMP kmp = new KMP();
        int res = kmp.kmp("xxxababa", "bab");
        System.out.println(res);
    }
    public int kmp(String str, String sub) {
        int[] next = getNext(sub);
        int i = 0, j = 0;
        int N = str.length(), M = sub.length();
        while (i < N && j < M) {
            while (j > 0 && sub.charAt(j) != str.charAt(i)) {
                j = next[j - 1];
            }
            if (str.charAt(i) == sub.charAt(j)) {
                j++;
            }
            i++;
        }
        return (j == M) ? i - M : -1;
    }

    private int[] getNext(String sub) {
        int[] next = new int[sub.length()];
        int j = 0;
        for (int i = 1; i < sub.length(); i++) {
            while (j > 0 && sub.charAt(j) != sub.charAt(i)) {
                j = next[j - 1];
            }

            if (sub.charAt(i) == sub.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
