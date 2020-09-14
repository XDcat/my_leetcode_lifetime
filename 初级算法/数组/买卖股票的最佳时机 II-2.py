# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__mtime__ = 2020/9/10
__project__ = prepare_for_postgraduate_recommendation
Fix the Problem, Not the Blame.
"""

class Solution(object):
    def maxProfit(self, prices):
        """
        遍历法
        start: 以每一个点为起点买，i: 之后的都尝试了一次
        :type prices: List[int]
        :rtype: int
        """
        i = 0
        peak = prices[i]
        valley = prices[i]
        profit = 0
        while i < len(prices) - 1:
            # 必须先找谷底，再找峰
            while i < len(prices) - 1 and prices[i] >= prices[i + 1]:
                i += 1
            valley = prices[i]
            while i < len(prices) - 1 and prices[i] <= prices[i + 1]:
                i += 1
            peak = prices[i]
            profit += peak - valley

        return profit


prices = [7,1,5,3,6,7]
res = Solution().maxProfit(prices)
print(res)

