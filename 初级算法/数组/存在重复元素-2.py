# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__mtime__ = 2020/9/10
__project__ = prepare_for_postgraduate_recommendation
Fix the Problem, Not the Blame.
"""


class Solution(object):
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        nums = sorted(nums)
        for i in range(len(nums) - 1):
            if (nums[i] == nums[i + 1]):
                return True
        return False



nums =[1,2,3,1]
res = Solution().containsDuplicate(nums)
print(res)