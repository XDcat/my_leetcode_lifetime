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
    values = [0] + values
    
    results = [[0] * (capacity + 1) for i in range(N + 1)]  # 行为物体，列为剩余空间
    for i in range(1, N + 1):
        for j in range(0, capacity + 1):
            k = 0  # 权重
            max_res = 0
            print(i, len(weights))
            while k * weights[i] <= j:
                # 保证 j 能够容纳 k 个当前物品
                cur_res = results[i-1][j - k * weights[i]] + k * values[i]
                if cur_res > max_res:
                    max_res = cur_res
                k += 1
            results[i][j] = max_res

    return results[-1][-1]


if __name__ == '__main__':
    weights= [5, 8]
    values = [5, 7]
    capacity = 10
    res = find_max(weights, values, capacity)
    print(res)
