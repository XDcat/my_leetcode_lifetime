# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/5/21
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''
from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        def backtracking(t, cur):
            if sum(t) == target:
                res.append(t[:])
                return
            elif sum(t) > target:
                return
            for i in range(cur, len(candidates)):
                t.append(candidates[i])
                backtracking(t, i)
                t.pop()

        res = []
        candidates = sorted(candidates)
        backtracking([], 0)
        return res


if __name__ == '__main__':
    res = Solution().combinationSum([2, 3, 5], 8)
    print(res)
