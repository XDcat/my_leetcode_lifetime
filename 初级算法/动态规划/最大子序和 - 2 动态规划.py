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
        # 动态规划
        # f(n) 为以 nums[n] 结尾的最大连续和
        # f(n) = max(f(n-1) + nums[n], nums[n])
        results = nums[:]
        for i in range(1, len(nums)):
            results[i] = max(results[i - 1] + nums[i], nums[i])
        return max(results)


if __name__ == '__main__':
    print(
        Solution().maxSubArray(
            [-2, 1, -3, 4, -1, 2, 1, -5, 4]
            # [-2, 1]
            # [1]
        )

    )
