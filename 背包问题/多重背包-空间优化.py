# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__mtime__ = 2020/9/21
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
"""


def find_max(weights, values, amounts, capacity):
    """
    多重背包问题
    状态转移方程：f(i, j) = max(f(i-1, j-k*w[i]) + k * v[i]), k 为自变量, 0 <= k <= amounts[i]
    :param weights: list 物体占据的位置
    :param values: list 物体的价值
    :param amounts: list 物体的限制数目
    :param capacity: int/float 背包的大小
    :return: 返回能够装的最大的值
    """
    N = len(weights)
    results = [0] * (capacity + 1)
    for i in range(N):
        for j in range(capacity, 0 - 1, -1):
            max_profit = 0
            k = 0
            while k <= amounts[i] and k * weights[i] <= j:
                cur_profit = results[j - k * weights[i]] + k * values[i]
                if cur_profit > max_profit:
                    max_profit = cur_profit
                k += 1
            results[j] = max_profit
    return results[-1]

if __name__ == '__main__':
    amounts = [4, 3, 2]
    values = [2, 3, 4, ]
    weights = [3, 4, 5]
    res = find_max(weights, values, amounts, 15)
    print(res)  # 11