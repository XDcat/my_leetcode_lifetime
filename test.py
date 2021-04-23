# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2020/9/20
__project__ = leetcode 刷题
Fix the Problem, Not the Blame.
'''

def find_max(weights, values, capacity):
    """
    多重背包问题
    状态转移方程：f(i, j) = max(f(i-1, j-k*w[i]) + k * v[i]), k 为自变量
    :param weights: list 物体占据的位置
    :param values: list 物体的价值
    :param capacity: int/float 背包的大小
    :return: 返回能够装的最大的值
    """
    N = len(weights)
    weights = [0] + weights
    values = [0] +values

    dp = [[0] * (capacity + 1) for _ in range(N + 1)]
    for i in range(1, N + 1):
        for j in range(1, capacity + 1):
            if j - weights[i] >= 0:
                dp[i][j] = max(dp[i-1][j], dp[i][j - weights[i]] + values[i])

    return dp[-1][-1]


if __name__ == '__main__':
    weights= [5, 8]
    values = [5, 7]
    capacity = 10
    res = find_max(weights, values, capacity)
    print(res)
