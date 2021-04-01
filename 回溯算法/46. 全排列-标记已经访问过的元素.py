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

        def backtracking(used, t):
            if len(t) == len(nums):
                res.append(t[:])
                return
            for i in range(0, len(nums)):
                if used[i]:
                    continue
                t.append(nums[i])
                used[i] = True
                backtracking(used, t)
                used[i] = False
                t.pop()

        res = []
        used = [False] * len(nums)
        backtracking(used, [])
        return res


if __name__ == '__main__':
    l = [1, 2, 3]
    res = Solution().permute(l)
    print(res)
