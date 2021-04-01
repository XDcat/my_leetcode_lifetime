# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/4/1
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''


class Solution(object):
    def clumsy(self, N):
        """
        :type N: int
        :rtype: int
        """
        # 直接构建表达式，让python计算
        exp = ""
        ms = "* // + -".split()
        for i in range(N - 1):
            exp += str(N - i) + ms[i % 4]
        exp += "1"

        res = eval(exp)
        return res



if __name__ == '__main__':
    # print(Solution().clumsy(4))
    print(Solution().clumsy(10))
