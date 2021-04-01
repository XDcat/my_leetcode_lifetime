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
                # 这里的 i - 1 是为 cur - 1，也就到了上一层
                # 但是我们只需要比较这一层的，所以设置了 used 来判断是否在这一层
                if i >= 1 and used[i - 1] == False and nums[i] == nums[i - 1]:
                    continue
                t.append(nums[i])
                used[i] = True
                backtracking(t, i + 1)
                used[i] = False
                t.pop()

        nums = sorted(nums)
        res = []
        used = [False] * len(nums)
        backtracking([], 0)
        return res


if __name__ == '__main__':
    nums = [1, 2, 2]
    # nums = [0]
    nums = [4,4,4,1,4]
    res = Solution().subsetsWithDup(nums)
    print(res)
