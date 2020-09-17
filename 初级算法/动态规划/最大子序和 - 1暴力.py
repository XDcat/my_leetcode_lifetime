# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__mtime__ = 2020/9/17
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
"""


class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max_nums = nums[0]
        for i in range(1, len(nums)):
            max_tmp = max([sum(nums[j: i + 1]) for j in range(i + 1)])
            max_nums = max(max_nums, max_tmp)
        return max_nums


if __name__ == '__main__':
    print(
        Solution().maxSubArray(
            # [-2, 1, -3, 4, -1, 2, 1, -5, 4]
            # [-2, 1]
            [1]
        )

    )
