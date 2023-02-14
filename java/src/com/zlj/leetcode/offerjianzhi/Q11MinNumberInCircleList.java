package com.zlj.leetcode.offerjianzhi;

public class Q11MinNumberInCircleList {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int i = solution.minArray(new int[]{1, 2, 3});
        System.out.println(i);
    }
}

class Solution {
    public int minArray(int[] numbers) {
        if (numbers.length < 2){
            return numbers[0];
        }


        for (int i = 1; i < numbers.length; i ++){
            int a1 = numbers[i - 1];
            int a2 = numbers[i];
            if (a2 < a1) {
                return a2;
            }
        }

        return numbers[0];
    }
}
class Solution1 {
    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high){
            int mid = low + (high - low) / 2;
            if (numbers[mid] < numbers[high]){
                high = mid;
            } else if (numbers[mid] > numbers[high]){
                low = mid + 1;
            } else{
                high --;
            }
        }
        return numbers[low];
    }
}
