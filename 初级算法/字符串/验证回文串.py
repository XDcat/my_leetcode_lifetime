# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__mtime__ = 2020/9/11
__project__ = prepare_for_postgraduate_recommendation
Fix the Problem, Not the Blame.
"""


class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        s = s.lower()
        import re
        res = re.findall("[a-z0-9]", s)
        res = "".join(res)
        return res == res[::-1]


print(
    Solution().isPalindrome(
        "A man, a plan, a canal: Panama"
    )
)
