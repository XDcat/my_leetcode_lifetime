# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2022/9/12
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''
from typing import List


class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        result = float("inf")
        i = 0  # 起始位置
        length = 0  # 结束位置
        isum = 0  # 窗口内求和

        for j in range(len(nums)):
            isum += nums[j]
            while isum >= target:
                length = j - i + 1
                result = min(result, length)
                # 变化窗口前端
                isum = isum - nums[i]
                i = i + 1  # 不断的变化前端
        if result == float("inf"):
            return 0
        else:
            return result


if __name__ == '__main__':
    s = Solution()
    print(s.minSubArrayLen(7, [2, 3, 1, 2, 4, 3]))
