# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
"""
import time


class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        nums = sorted(nums)
        for i in range(len(nums)):
            # 如果第一个数字大于0，则不可能为 0，直接跳过
            if nums[i] > 0:
                continue

            # 保证第一个数字去重
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            res += self.twoSum(nums, i + 1, len(nums) - 1, - nums[i])
        return res

    def twoSum(self, nums, left, right, target):
        res = []
        while left < right:
            s23 = nums[left] + nums[right]
            if s23 == target:
                res.append([-target, nums[left], nums[right]])

                # 由于需要继续循环，所以也要更新 left right
                while left < right and nums[left] == nums[left + 1]:
                    left += 1
                left += 1

                while left < right and nums[right] == nums[right - 1]:
                    right -= 1
                right -= 1

            elif s23 > target:
                # 减少数值，right 左移
                right -= 1
            else:
                # 增大数值，left 右移
                left += 1

        return res


if __name__ == '__main__':
    s = Solution()
    cases = [[-4, -2, -1], [1, -1, -1, 0], [-1, 0, 1, 2, -1, -4]]
    for case in cases:
        print("------")
        stime = time.time()
        res = s.threeSum(case)
        etime = time.time()
        print("case:", case)
        print("Run time:", etime - stime)
        print(res)
