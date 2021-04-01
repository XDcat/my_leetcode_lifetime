# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/3/31
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''


class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """

        def backtracking(t):
            if len(t) == len(nums):
                res.append(t[:])

            for i in range(len(nums)):
                if used[i]:
                    continue
                elif i >= 1 and nums[i] == nums[i - 1] and used[i-1] == False:
                    continue

                t.append(nums[i])
                used[i] = True
                backtracking(t)
                used[i] = False
                t.pop()

        nums = sorted(nums)
        used = [False] * len(nums)
        res = []
        backtracking([])
        return res


if __name__ == '__main__':
    nums = [1, 1, 2]
    res = Solution().permuteUnique(nums)
    print(res)
