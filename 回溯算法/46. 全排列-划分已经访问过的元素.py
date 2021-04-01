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

        def backtracking(cur, t):
            if cur == len(nums):
                res.append(nums[:])
                return
            for i in range(cur, len(nums)):
                nums[cur], nums[i] = nums[i], nums[cur]
                backtracking(cur + 1, t)
                nums[i], nums[cur] = nums[cur], nums[i]

        res = []
        backtracking(0, [])
        return res


if __name__ == '__main__':
    l = [1, 2, 3]
    res = Solution().permute(l)
    print(res)
