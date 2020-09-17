# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__mtime__ = 2020/9/17
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
"""


class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if len(prices) == 0:
            return 0

        max_profit = 0
        min_prices = prices[0]
        for i in range(1, len(prices)):
            min_prices = min(min_prices, prices[i])
            max_profit = max(max_profit, prices[i] - min_prices)
        return max_profit


if __name__ == '__main__':
    prices = [7, 1, 5, 3, 6, 4]

    res = Solution().maxProfit(prices)
    print(res)
