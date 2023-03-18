# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
"""


class Solution(object):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        res = []
        nums = sorted(nums)
        origin_target = target
        for i in range(len(nums)):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            for j in range(i + 1, len(nums)):
                if j > i + 1 and nums[j] == nums[j - 1]:
                    continue

                target = origin_target - nums[i] - nums[j]
                left = j + 1
                right = len(nums) - 1

                while left < right:
                    s23 = nums[left] + nums[right]

                    if s23 == target:
                        res.append([nums[i], nums[j], nums[left], nums[right]])

                        while left < right and nums[right] == nums[right - 1]:
                            right -= 1
                        right -= 1

                        while left < right and nums[left] == nums[left + 1]:
                            left += 1
                        left += 1

                    elif s23 < target:
                        left += 1
                    else:
                        right -= 1

        return res


if __name__ == '__main__':
    s = Solution()
    cases = [
        ([1, -2, -5, -4, -3, 3, 3, 5], -11),
    ]

    for case in cases:
        res = s.fourSum(*case)
        print(res)
