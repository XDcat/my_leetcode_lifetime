# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__mtime__ = 2020/9/16
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
"""


class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: None Do not return anything, modify nums1 in-place instead.
        """
        p1, p2 = 0, 0  # nums1, nums2's pointer
        while p2 < n:
            # compare with two nums
            # if p1 > p2, p1 set to next, p2 keep unchanged
            # if p1 <= p2, p1 set to next, p2 set to next, and need to put the nums[p2] into nums[p1]
            # and nums[p1:] need to put back one position
            if m == 0:
                nums1[p1] = nums2[p2]
                p1 += 1
                p2 += 1
            else:
                if nums1[p1] < nums2[p2]:
                    p1 += 1
                    m-=1
                else:
                    for i in range(len(nums1) - 1, p1, -1):
                        nums1[i] = nums1[i - 1]

                    nums1[p1] = nums2[p2]
                    p1 += 1
                    p2 += 1


if __name__ == '__main__':
    nums1 = [1, 2, 3, 0, 0, 0]
    m = 3
    nums2 = [2, 5, 6]
    n = 3
    Solution().merge(nums1, m, nums2, n)
    print(nums1)
