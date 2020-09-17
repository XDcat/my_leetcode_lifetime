# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__mtime__ = 2020/9/17
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
"""


class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) < 2:
            return max(nums + [0])

        profits = [0] * len(nums)
        profits[0] = nums[0]
        profits[1] = max(nums[:2])
        for i in range(2, len(nums)):
            profits[i] = max(profits[i - 2] + nums[i], profits[i - 1])
        return profits[-1]


if __name__ == '__main__':
    print(
        Solution().rob(
            # [1, 2, 3, 1]
            [2, 7, 9, 3, 1]
        )
    )
