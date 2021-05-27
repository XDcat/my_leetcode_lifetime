# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/3/29
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''

"""
题目来源：http://acm.hdu.edu.cn/showproblem.php?pid=2191
"""


def solve(p, values, weights, counts):
    """
    完全背包问题
    """
    N = len(values)
    values = [0] + values
    weights = [0] + weights
    counts = [0] + counts
    # dp[i][j] = max(dp[i-1][j - k * v[i] + k * w[i])
    dp = [[0, ] * (p + 1) for _ in range(N + 1)]
    for i in range(1, N + 1):
        for j in range(1, p + 1):
            max_profit = 0
            for k in range(counts[i] + 1):
                if j - k * values[i] >= 0:
                    max_profit = max(max_profit, dp[i - 1][j - k * values[i]] + k * weights[i])
                else:
                    break
            dp[i][j] = max_profit
    return dp[-1][-1]


if __name__ == '__main__':
    p = 8  # 资金 -》 背包大小
    values = [2, 4]  # 米的价格
    weights = [100, 100]  # 米的重量
    counts = [4, 2]  # 米的袋数
    res = solve(p, values, weights, counts)
    print(res)
