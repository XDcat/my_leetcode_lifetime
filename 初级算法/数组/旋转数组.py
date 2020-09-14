# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__mtime__ = 2020/9/10
__project__ = prepare_for_postgraduate_recommendation
Fix the Problem, Not the Blame.
"""


class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        if k < 1:
            return
        k = k % len(nums)
        self.reserve(nums, 0, len(nums) - 1)
        self.reserve(nums, 0, k - 1)
        self.reserve(nums, k, len(nums) - 1)

    def reserve(self, nums, lo, hi):
        while lo < hi:
            nums[lo], nums[hi] = nums[hi], nums[lo]
            lo += 1
            hi -= 1

nums = [1,2,3,4,5,6,7]
k = 3
Solution().rotate(nums, k)
print(nums)