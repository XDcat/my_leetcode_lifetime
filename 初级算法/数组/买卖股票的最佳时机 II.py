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
        max = 0
        for start in range(len(prices)):
            maxprofit = 0
            for i in range(start + 1, len(prices)):
                profit = self.maxProfit(prices[i + 1: ]) + prices[i] - prices[start]
                if (profit > maxprofit):
                    maxprofit = profit

            if (maxprofit > max):
                max = maxprofit

        return max

prices = [7,1,5,3,6,4]
res = Solution().maxProfit(prices)
print(res)

