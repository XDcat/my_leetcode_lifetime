package com.zlj.q1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        char[][] chars = new char[n][m];
        for (int i = 0; i < n; i++) {
            chars[i] = in.next().toCharArray();
        }
        Solution solution = new Solution();
        System.out.println(solution.solve(chars, n, m));
    }
}

class Solution{
    public int solve(char[][] chars, int n, int m){
        int countN = n - 2 + 1;
        int countM = m - 2 + 1;
        int[][] countY = new int[countN][countM];
        int[][] countO = new int[countN][countM];
        int[][] countU = new int[countN][countM];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                update(countY, 'y', chars[i][j], i, j, countN, countM);
                update(countO, 'o', chars[i][j], i, j, countN, countM);
                update(countU, 'u', chars[i][j], i, j, countN, countM);
            }
        }
        int res = 0;
        for (int i = 0; i < countN; i++) {
            for (int j = 0; j < countM; j++) {
                if (countY[i][j] >0 && countO[i][j] > 0 && countU[i][j] > 0){
                    res ++;
                }
            }
        }
        return res;
    }

    int[][] move = new int[][]{{-1, -1}, {-1, 0}, {0, -1}, {0, 0}};
    private void update(int[][] count, char target, char c, int i, int j, int countN, int countM){
        if (c == target){
            for (int[] m :
                    move) {
                int movei = i + m[0];
                int movej = j + m[1];
                if (movei >= 0 && movei < countN && movej >=0 && movej < countM){
                    count[movei][movej] ++;
                }
            }
        }
    }
}
