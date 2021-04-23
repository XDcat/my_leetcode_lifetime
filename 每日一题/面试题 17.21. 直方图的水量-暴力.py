# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/4/2
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''
from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        res = 0
        N = len(height)
        for i in range(1, N - 1):
            leftMax = 0
            for j in range(i):
                leftMax = max(leftMax, height[j])
            rightMax = 0
            for j in range(i + 1, N):
                rightMax = max(rightMax, height[j])

            maxHeight = min(rightMax, leftMax)
            # print(f"i = {i}, left = {leftMax}, rigth = {rightMax}")
            if height[i] < maxHeight:
                res += maxHeight - height[i]
        return res


if __name__ == '__main__':
    h = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
    h = [5, 2, 1, 2, 1, 5]
    h = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
    res = Solution().trap(h)
    print(res)
