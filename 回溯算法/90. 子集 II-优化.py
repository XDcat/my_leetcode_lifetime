# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/3/31
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''


class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """

        def backtracking(t, cur):
            res.append(t[:])
            for i in range(cur, len(nums)):
                # 与优化前相比，i 无法为 cur - 1，也就无法到达上一层
                # 所以都直接是在当前层进行的对比
                if i > cur and nums[i] == nums[i - 1]:
                    continue
                t.append(nums[i])
                backtracking(t, i + 1)
                t.pop()

        nums = sorted(nums)
        res = []
        backtracking([], 0)
        return res


if __name__ == '__main__':
    nums = [1, 2, 2]
    # nums = [0]
    res = Solution().subsetsWithDup(nums)
    print(res)
