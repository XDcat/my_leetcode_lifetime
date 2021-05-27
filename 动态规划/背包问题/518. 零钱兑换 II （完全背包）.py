# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/3/19
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''

from typing import List


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        N = len(coins)
        coins = [0] + coins

        dp = [1] + [0] * amount
        for i in range(1, N + 1):
            for j in range(coins[i], amount + 1):
                print("-----------")
                print(dp)
                print(i, j, )
                dp[j] = dp[j] + dp[j - coins[i]]
                print(dp)

        return dp[-1]


if __name__ == "__main__":
    mount = 5
    coins = [1, 2, 5]
    print(Solution().change(mount, coins))
