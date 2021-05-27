# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/5/21
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''
from typing import List


class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        def backtracking(t, cur):
            if len(t) == k:
                if sum(t) == n:
                    res.append(t[:])
                return
            if sum(t) >= n:  # 剪枝
                return
            for i in range(cur, 9 - (k - len(t)) + 1 + 1):  # 剪枝
                t.append(i)
                backtracking(t, i + 1)
                t.pop()

        res = []
        backtracking([], 1)
        return res


if __name__ == '__main__':
    k = 2
    n = 18
    res = Solution().combinationSum3(k, n)
    print(res)
