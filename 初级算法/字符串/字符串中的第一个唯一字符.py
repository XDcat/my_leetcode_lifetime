# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__mtime__ = 2020/9/11
__project__ = prepare_for_postgraduate_recommendation
Fix the Problem, Not the Blame.
"""
class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        # from collections import OrderedDict
        from collections import Counter
        # map = OrderedDict()  # hash 表
        counter = Counter(s)
        for i, j in enumerate(s):
            if counter[j] == 1:
                return i
        return -1


res = Solution().firstUniqChar(
    "leetcode"
)
print(res)
