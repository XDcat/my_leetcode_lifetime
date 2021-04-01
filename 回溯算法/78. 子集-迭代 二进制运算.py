# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/3/31
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''


class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        max_permutation = 2 ** len(nums) - 1
        for p in range(max_permutation + 1):
            res1 = []
            flag = 1
            for i in nums:
                if p & flag:
                    res1.append(i)
                flag = flag << 1
            res.append(res1)
        return res
