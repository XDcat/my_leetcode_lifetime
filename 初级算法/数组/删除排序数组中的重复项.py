# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__mtime__ = 2020/9/10
__project__ = prepare_for_postgraduate_recommendation
Fix the Problem, Not the Blame.
"""

class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        i, j = 0, 1
        while j < len(nums):
            if nums[j] != nums[i]:
                i += 1
                nums[i] = nums[j]
            j += 1
        return i + 1


nums = [1, 1, 2, 2, 3, 3, 3, 4, 5, 5]
res = Solution().removeDuplicates(nums)
print(res)
print(nums[: res])

