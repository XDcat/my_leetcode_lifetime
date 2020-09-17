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
        if len(nums) < 1:
            return 0

        p, q, r = 0, 0, nums[0]

        for i in nums:
            r = max(p + i, q)
            p, q = q, r
        return r


if __name__ == '__main__':
    print(
        Solution().rob(
            # [1, 2, 3, 1]
            # [2, 7, 9, 3, 1]
            [3]
        )
    )
