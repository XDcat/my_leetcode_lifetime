# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__mtime__ = 2020/9/11
__project__ = prepare_for_postgraduate_recommendation
Fix the Problem, Not the Blame.
"""
class Solution(object):
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        import re
        # 使用正则匹配
        str = str.lstrip()
        mo = re.match("\d+|-\d+|\+\d+", str)
        if mo:
            # 匹配到了才可以返回
            res = mo.group()
            res = int(res)
            if res > ((1 << 31) - 1):
                return (1 << 31) - 1
            elif res < (-1 * (1 << 31)):
                return -1 * (1 << 31)
            return res
        else:
            return 0

print(
    Solution().myAtoi(
"2147483646"
    )
)