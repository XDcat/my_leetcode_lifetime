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
        # 交换顺序，让效率更高
        if len(nums2) > len(nums1):
            nums1, nums2 = nums2, nums1
        from collections import Counter
        counter1 = Counter(nums1)
        res = []
        for num in nums2:
            # 获取 num 并返回默认值 0
            if counter1.get(num, 0) > 0:
                res.append(num)
                counter1[num] -= 1
        return res



nums1 = [4,9,5]
nums2 = [9,4,9,8,4]
print(Solution().intersect(nums1, nums2))
