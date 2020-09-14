# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__mtime__ = 2020/9/11
__project__ = prepare_for_postgraduate_recommendation
Fix the Problem, Not the Blame.
"""
class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        s = sorted(s)
        t = sorted(t)
        return s == t
