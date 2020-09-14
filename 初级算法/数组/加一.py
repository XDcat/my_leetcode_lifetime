# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__mtime__ = 2020/9/10
__project__ = prepare_for_postgraduate_recommendation
Fix the Problem, Not the Blame.
"""
class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        addition = 1
        i = len(digits) - 1
        while i >= 0:
            digits[i] += addition
            if digits[i] >= 10:
                addition = 1
                digits[i] -= 10
            else:
                addition = 0
                break
            i -= 1
        if addition == 1:
            digits.insert(0, 1)
        return digits

nums = [9, 9, 9]
res = Solution().plusOne(nums)
print(res)