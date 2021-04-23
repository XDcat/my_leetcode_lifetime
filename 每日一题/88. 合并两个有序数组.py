# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/4/5
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''
from typing import List


class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        aux = nums1[:m] + nums2[:n]  # copy

        # pointers of nums1 and nums2
        p1 = 0
        p2 = m
        for i in range(m + n):
            if p1 >= m:
                nums1[i] = aux[p2]
                p2 += 1
            elif p2 >= m + n:
                nums1[i] = aux[p1]
                p1 += 1
            elif aux[p1] <= aux[p2]:
                nums1[i] = aux[p1]
                p1 += 1
            else:
                nums1[i] = aux[p2]
                p2 += 1
        # print(nums1)


if __name__ == '__main__':
    Solution().merge(nums1=[1, 2, 3, 0, 0, 0], m=3, nums2=[2, 5, 6], n=3)
