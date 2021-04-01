# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/3/31
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''


class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """

        def tracebacking(cur, t):
            if cur == len(nums) or cur < 0:
                res.append(t[:])
                return

            # 不取
            tracebacking(-1, t)
            for i in range(cur, len(nums)):
                t.append(nums[i])
                tracebacking(i + 1, t)
                t.pop()

        res = []
        tracebacking(0, [])
        return res


if __name__ == '__main__':
    nums = [1, 2, 3]
    res = Solution().subsets(nums)
    print(res)
