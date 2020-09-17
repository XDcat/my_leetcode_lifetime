# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__mtime__ = 2020/9/16
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
"""
class Solution:
    def climbStairs(self, n: int) -> int:
        p, q, r = 0, 0, 1
        for i in range(1, n + 1):
            p, q = q, r
            r = p + q
        return r



if __name__ == '__main__':
    n = 3
    res = Solution().climbStairs(n)
    print(res)