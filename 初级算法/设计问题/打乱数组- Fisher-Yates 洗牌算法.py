# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__mtime__ = 2020/9/17
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
"""

import random


class Solution(object):

    def __init__(self, nums):
        """
        :type nums: List[int]
        """
        self.array = nums
        self.origin = nums[:]

    def reset(self):
        """
        Resets the array to its original configuration and return it.
        :rtype: List[int]
        """
        self.array = self.origin[:]
        return self.array

    def shuffle(self):
        """
        Returns a random shuffling of the array.
        :rtype: List[int]
        """
        for i in range(len(self.array)):
            aux = random.randrange(i, len(self.array))
            self.array[i], self.array[aux] = self.array[aux], self.array[i]
        return self.array


if __name__ == '__main__':
    nums = [1, 2, 3, 4, 5, 6, 7]
    sol = Solution(nums)
    print(sol.shuffle())
    print(sol.reset())
