# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/4/7
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''

from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        return target in nums
