# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/4/22
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''
from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        # 动态规划
        # f(i) 表示前 i 个元素的最大子序和
        # f(i) = max(f(i- 1) + nums[i], nums[i])
        # 最终的结果就是 max(f)
        # 由于只会用到上一个状态，所以可以压缩空间
        pre = 0
        res = nums[0]
        for i in nums:
            pre = max(i, pre + i)
            res = max(pre, res)
        return res



if __name__ == '__main__':
    nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
    res = Solution().maxSubArray(nums)
    print(res)
