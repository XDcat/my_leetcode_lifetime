# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/4/8
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''
from typing import List


class Solution:
    def findMin(self, nums: List[int]) -> int:
        i = 0
        while i < len(nums) - 1:
            if nums[i] > nums[i + 1]:
                return nums[i + 1]
            i += 1
        return nums[0]


if __name__ == '__main__':
    nums = [3, 4, 5, 1, 2]
    print(Solution().findMin(nums))
