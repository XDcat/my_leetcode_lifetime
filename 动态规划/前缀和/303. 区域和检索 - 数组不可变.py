# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/4/23
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''

from typing import List


class NumArray:

    def __init__(self, nums: List[int]):
        self.nums = nums
        self.sums = [0]
        _sums = self.sums
        for i in nums:
            _sums.append(i + _sums[-1])

    def sumRange(self, left: int, right: int) -> int:
        _sums = self.sums
        return _sums[right + 1] - _sums[left]

# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(left,right)
