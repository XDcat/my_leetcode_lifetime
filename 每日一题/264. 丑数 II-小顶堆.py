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
        factors = [2, 3, 5]
        seen = {1}
        heap = [1]
        for i in range(n - 1):
            curr = heapq.heappop(heap)
            for f in factors:
                t = curr * f
                if t not in seen:
                    seen.add(t)
                    heapq.heappush(heap, t)
        return heapq.heappop(heap)


if __name__ == '__main__':
    n = 10
    for i in range(1, n + 1):
        print(
            Solution().nthUglyNumber(i)
        )
