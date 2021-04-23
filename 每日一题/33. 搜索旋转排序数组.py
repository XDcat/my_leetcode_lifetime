# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/4/7
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''
from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        self.nums = nums
        self.target = target
        N = len(nums)
        if N == 0:
            return -1
        return self.aux(0, N - 1)

    def aux(self, lo, hi):
        if lo > hi:
            return -1
        mid = (lo + hi) // 2
        if self.nums[mid] == self.target:
            return mid
        else:
            if self.nums[lo] <= self.nums[mid]:
                # 左边有序
                if self.nums[lo] <= self.target < self.nums[mid]:
                    hi = mid - 1
                else:
                    lo = mid + 1
            else:
                # 右边有序
                if self.nums[mid] < self.target <= self.nums[hi]:
                    lo = mid + 1
                else:
                    hi = mid - 1

            return self.aux(lo, hi)


if __name__ == '__main__':
    nums = [3, 1]
    target = 1
    print(Solution().search(nums, target))
