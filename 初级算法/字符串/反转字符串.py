# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__mtime__ = 2020/9/11
__project__ = prepare_for_postgraduate_recommendation
Fix the Problem, Not the Blame.
"""


class Solution(object):
    def reverseString(self, s):
        """
        :type s: List[str]
        :rtype: None Do not return anything, modify s in-place instead.
        """
        N = len(s)
        for i in range(N // 2):
            s[i], s[N - 1 - i] = s[N - 1 - i], s[i]



s = list("helloworld")
Solution().reverseString(s)
print(s)
