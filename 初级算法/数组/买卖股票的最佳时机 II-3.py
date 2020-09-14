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
        profit = 0
        for i in range(1, len(prices)):
            if (prices[i] > prices[i - 1]):
                profit += prices[i] - prices[i - 1]
        return profit


prices = [7,1,5,3,6,4]
res = Solution().maxProfit(prices)
print(res)

