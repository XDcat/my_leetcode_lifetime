# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/3/31
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''


class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """

        def backtracking(rest, t):
            if len(t) == len(nums):
                res.append(t[:])
                return
            for i in rest:
                t.append(i)
                rest1 = []
                for j in rest:
                    if j != i:
                        rest1.append(j)
                backtracking(rest1, t)
                t.pop()

        res = []
        backtracking(nums, [])
        return res


if __name__ == '__main__':
    l = [1, 2, 3]
    res = Solution().permute(l)
    print(res)
