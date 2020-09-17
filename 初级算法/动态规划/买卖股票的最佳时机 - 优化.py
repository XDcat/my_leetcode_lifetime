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
        max_profit = 0
        min_prices = prices[0]
        for i in prices:
            min_prices = min(min_prices, i)
            max_profit = max(max_profit, i - min_prices)
        return max_profit


if __name__ == '__main__':
    prices = [7, 1, 5, 3, 6, 4]

    res = Solution().maxProfit(prices)
    print(res)
