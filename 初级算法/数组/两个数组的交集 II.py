# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__mtime__ = 2020/9/10
__project__ = prepare_for_postgraduate_recommendation
Fix the Problem, Not the Blame.
"""
class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        # 排序
        nums1 = sorted(nums1)
        nums2 = sorted(nums2)
        res = []
        i1 = i2 = 0
        while i1 < len(nums1) and i2 < len(nums2):
            if nums1[i1] > nums2[i2]:
                i2 += 1
            elif nums1[i1] == nums2[i2]:
                res.append(nums1[i1])
                i1 += 1
                i2 += 1
            else:
                i1 += 1
        return res

nums1 = [4,9,5]
nums2 = [9,4,9,8,4]
print(Solution().intersect(nums1, nums2))