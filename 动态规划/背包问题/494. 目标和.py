# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__mtime__ = 2020/9/21
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
"""
class Solution(object):
    def findTargetSumWays(self, nums, S):
        """
        转化为 01背包 问题：
        1. 设所有添加 - 的数的和为 x，添加 + 的数的和为 y
        2. 设 sum(nums) = sum, 则 x + y = sum
        3. 由题可知，S = x + y
        -> x = (sum + S) / 2, 其中 sum 和 S 为已知，所以只需要挑选符合 x 的数即可
        :type nums: List[int]
        :type S: int
        :rtype: int
        """
        sum_all = sum(nums)
        target, residue = divmod(sum_all + S, 2)
        if residue == 1 or abs(S) > sum_all:
            # 如果无法被 2 整除，说明无法达到指定值
            # 如果所有数的和都达不到，S 的绝对值，直接退出
            return 0

        # 01 背包算法，nums 为物品，target 为背包达到的值
        # f(i, j) = f(i-1,j) + f(i - 1, j - nums[i])
        # f(i, j) 表示将前 i 个物品放入 j 中的搭配次数
        # 当前可选可不选，不选择是 f(i - 1, j) ，选择时前一个状态要在 i - 1 时，背包大小为 j - nums[i]
        # 当前的次数就是两者之和
        bags = [1] + [0] * target
        for i in range(len(nums)):
            for j in range(target, nums[i] - 1, -1):
                bags[j] += bags[j - nums[i]]
        return bags[-1]

