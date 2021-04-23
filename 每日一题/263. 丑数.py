# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/4/10
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''

from typing import List
class Solution:
    def isUgly(self, n: int) -> bool:
        if n <= 0:
            return False
        for i in [2, 3, 5]:
            while n % i == 0:
                n = n // i
        # print(n)
        return n == 1



if __name__ == '__main__':
    n = 14
    res = Solution().isUgly(n)
    print(res)