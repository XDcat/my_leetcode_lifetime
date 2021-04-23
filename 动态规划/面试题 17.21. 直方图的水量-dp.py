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
        dp_height_left = [height[0], ] * N
        dp_height_right = [height[-1], ] * N
        for i in range(1, N):
            dp_height_left[i] = max(dp_height_left[i - 1], height[i])
            dp_height_right[i] = max(dp_height_right[i - 1], height[N - 1 - i])
        dp_height_right = dp_height_right[::-1]

        for i in range(1, N-1):
            max_height = min(dp_height_left[i], dp_height_right[i])
            if max_height > height[i]:
                res += max_height - height[i]

        return res


if __name__ == '__main__':
    h = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
    h = [5, 2, 1, 2, 1, 5]
    h = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
    h = []
    # h = [1]
    res = Solution().trap(h)
    print(res)
