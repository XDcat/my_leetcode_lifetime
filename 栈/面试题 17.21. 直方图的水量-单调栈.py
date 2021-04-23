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
        if len(height) <= 2:
            return 0
        res = 0
        N = len(height)

        stack = [0, ]

        for i in range(1, N):
            if height[i] < height[stack[-1]]:
                stack.append(i)
            elif height[i] == height[stack[-1]]:
                stack.append(i)
            else:
                while len(stack) > 0 and height[i] > height[stack[-1]]:
                    mid = stack.pop()
                    if len(stack) > 0:
                        left = stack[-1]
                        right = i
                        res += (min(height[left], height[right]) - height[mid]) * (right - left - 1)
                stack.append(i)
        return res


if __name__ == '__main__':
    h = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
    h = [5, 2, 1, 2, 1, 5]
    h = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
    # h = []
    # h = [1]
    res = Solution().trap(h)
    print(res)
