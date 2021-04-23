# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/4/2
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''
from typing import List


class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        queue = Myqueue()
        result = []
        for i in range(k):
            queue.put(nums[i])

        result.append(queue.first())
        for i in range(k, len(nums)):
            queue.pop(nums[i - k])
            queue.put(nums[i])
            result.append(queue.first())
        return result


from collections import deque


class Myqueue:
    def __init__(self):
        self.queue = deque()

    def put(self, value):
        while len(self.queue) > 0 and value > self.queue[-1]:
            self.queue.pop()
        self.queue.append(value)

    def pop(self, value):
        if len(self.queue) > 0 and self.queue[0] == value:
            self.queue.popleft()

    def first(self):
        return self.queue[0]

    def __str__(self):
        return list(self.queue)


if __name__ == '__main__':
    nums = [1, 3, 1, 2, 0, 5]
    k = 3
    res = Solution().maxSlidingWindow(nums, k)
    print(res)
