# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__mtime__ = 2020/9/11
__project__ = prepare_for_postgraduate_recommendation
Fix the Problem, Not the Blame.
"""
class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        current_str = "1"
        if n == 1:
            return current_str

        # 遍历次数
        for i in range(1, n):
            # 遍历字符串
            # 双指针访问
            # 指针1 当前字符
            # 指针2 探索字符
            point1, point2 = 0, 1
            tmp = ""  # 暂时的字符
            while(point2 < len(current_str)):
                s = current_str[point1]
                counter = 1
                while current_str[point2] == s and point2 < len(current_str):
                    counter += 1
                    point2 += 1
                tmp += "%d%d" % (counter, s)
                point1 = point2







