package com.zlj.daimasuixianglu.monotonicstack.q42;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution.trap(nums));
        
    }
}

class Solution {
    public int trap(int[] height) {
        // monotonic stack
        int res = 0;
        Deque<int[]> stack = new LinkedList<>();
        for (int i = 0; i < height.length; i++){
            while (stack.size() > 0 && height[i] > stack.peek()[0]){
                int[] middleList = stack.pop();
                if (stack.size() > 0){
                    int[] leftList = stack.peek();
                    res += (Math.min(leftList[0], height[i]) - middleList[0])
                                * (i - leftList[1] - 1);
                }
            }
            stack.push(new int[]{height[i], i});
        }
        return res;
    }
}