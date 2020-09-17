# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__mtime__ = 2020/9/16
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
"""
class Solution:
    def climbStairs(self, n: int) -> int:
        if n < 3:
            return n
        results = list(range(1, n + 1))
        for i in range(2, n):
            results[i] = results[i - 1] + results[i - 2]
        return results[-1]



if __name__ == '__main__':
    n = 3
    res = Solution().climbStairs(n)
    print(res)