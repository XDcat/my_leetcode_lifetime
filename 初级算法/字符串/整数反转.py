# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__mtime__ = 2020/9/11
__project__ = prepare_for_postgraduate_recommendation
Fix the Problem, Not the Blame.
"""
class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        """
        int 范围 [-2^31, 2^31 - 1]
        """
        # 符号位
        base = 1 if x >= 0 else -1
        # 边界
        boundary = 1 << 31 if x < 0 else (1 << 31)  - 1
        # 绝对值字符串
        x = str(abs(x))
        res = 0
        # res = int(x[::-1])
        for i in x[::-1]:
            res = res * 10 + int(i)
            if res > boundary:
                return 0
        return base * int(res)

n = 15342
print(
    Solution().reverse(n)
)
