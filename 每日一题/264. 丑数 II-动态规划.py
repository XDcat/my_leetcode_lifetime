# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/4/10
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''

import heapq


class Solution:
    def nthUglyNumber(self, n: int) -> int:
        dp = [1]
        p2 = 0
        p3 = 0
        p5 = 0
        for i in range(n - 1):
            n2, n3, n5 = dp[p2] * 2, dp[p3] * 3, dp[p5] * 5
            dp.append(min(n2, n3, n5))
            if n2 == dp[-1]:
                p2 += 1
            if n3 == dp[-1]:
                p3 += 1
            if n5 == dp[-1]:
                p5 += 1

        return dp[-1]


if __name__ == '__main__':
    n = 10
    for i in range(1, n + 1):
        print(
            Solution().nthUglyNumber(i)
        )
