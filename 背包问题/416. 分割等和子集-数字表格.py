# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2020/9/20
__project__ = leetcode 刷题
Fix the Problem, Not the Blame.
'''


"""
给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
注意:
每个数组中的元素不会超过 100
数组的大小不会超过 200
示例 1:
输入: [1, 5, 11, 5]
输出: true
解释: 数组可以分割成 [1, 5, 5] 和 [11].
示例 2:
输入: [1, 2, 3, 5]
输出: false
解释: 数组不能分割成两个元素和相等的子集.
"""
class Solution(object):
    def canPartition(self, nums):
        """
        其实就是寻找列表的子集，使得子集的和为 sum(nums) / 2,
        而对于每一个元素只有选或者不选两种抉择，所以这就是一个01背包，
        背包里刚好装下 sum(nums) / 2 的数值。

        01背包: f(i, j) = max(f(i-1, j), f(i-1, j-w[i]) + v[i])
        在这个题目中，f(i, j) 表示当访问第 i 个元素，容量为 j 时，是否可以满足题目的条件。
        f(i, j) -> {
            if j = nums[i], True;
            else, f(i-1, j) || f(i - 1, j - nums[i])

        }
        :type nums: List[int]
        :rtype: bool
        """
        sum_nums = sum(nums)
        if sum_nums %2 == 1:
            # 如果是奇数直接返回
            return False

        target = sum_nums // 2
        # 恰好满的背包问题，只有当空间是0且没有装物品的时候才有一个恰好的值，其他都是非法的值
        results = [0] + [float("-inf")] * target
        for i in range(len(nums)):
            for j in range(target, nums[i] - 1, -1):
                results[j] = max(results[j], results[j - nums[i]])
        return results[-1] == 0



if __name__ == '__main__':
    nums = [1, 5, 11, 5]
    # nums = [1, 2, 3, 5]
    print(
        Solution().canPartition(nums)
    )

