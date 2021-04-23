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
        N = len(nums)
        lo = 0
        hi = N - 1
        while nums[lo] > nums[hi]:
            mid = (lo + hi) // 2
            if nums[mid] >= nums[lo]:
                # 左边有序: 左大右小，找右边，mid 本身不为最小
                lo = mid + 1
            else:
                # 右边有序: 左大右小，找左边，mid 本身可能为最小
                hi = mid
        return nums[lo]


if __name__ == '__main__':
    nums = [
        [3, 4, 5, 1, 2],
        [4, 5, 6, 7, 0, 1, 2],
        [11, 13, 15, 17],
        [2, 1],
        [3, 1, 2],
    ]
    for i in nums:
        print(Solution().findMin(i))
