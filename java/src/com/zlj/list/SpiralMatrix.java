package com.zlj.list;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class SpiralMatrix {
    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0){
                return List.of();
            }

            int n = matrix.length, m = matrix[0].length;
            int[] res = new int[n * m];

            int l = 0, r = m - 1, t = 0, b = n - 1;
            int x = 0;
            while (x < n * m){
                for (int i = l; i <= r; i ++){
                    res[x++] = matrix[t][i];
                }
                if (++t > b){
                    break;
                }

                for (int i = t; i <= b; i ++){
                    res[x++] = matrix[i][r];
                }
                if (--r < l){
                    break;
                }

                for (int i = r; i >= l; i --){
                    res[x++] = matrix[b][i];
                }
                if (--b < t){
                    break;
                }

                for (int i = b; i >= t; i --){
                    res[x++] = matrix[i][l];
                }
                if (++l > r){
                    break;
                }
            }
            return Arrays.stream(res).boxed().collect(Collectors.toList());

        }
    }
}
