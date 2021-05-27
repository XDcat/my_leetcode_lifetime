# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__mtime__ = 2020/9/18
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
"""


def find_max(w, v, space) -> int:
    """
    01背包 - 动态规划
    状态迁移方程: f[i, j] = max(f[i-1, j], f[i - 1, j - w[i]] + v[i])
    在第 i 个物品，背包空间剩余 j 时，将会有两种选择:
        1. 不拿当前物品: 收益为上一个物品时，背包大小为 j 时的收益
        2. 拿当前物品: 当前的背包时 j，当前取了，对于上一个状态，背包只有 j - w[i]，收益也就是 f[i - 1, j - w[i]] + v[i]
    然后再其中去最大值，就是当前的最大值，一直迭代到最后.
    :param w: 物体重量
    :param v: 物体价值
    :param space: 背包的大小
    :return:  最大价值
    """
    N = len(w)  # 物体数目
    # 创建 N * space 大小的矩阵
    # 行代表到达哪一个物品，[0, N]，哑物品 0
    # 列代表剩余空间，[0, space]
    # ! 注意边界都可以达到
    w = [0] + w
    v = [0] + v
    results = [0] * (space + 1)
    for i in range(1, N + 1):
        for j in range(space, 0, -1):
            if j >= w[i]:
                results[j] = max(results[j], results[j - w[i]] + v[i])
    return results[-1]


if __name__ == '__main__':
    w = [2, 3, 4, 5]
    v = [3, 4, 5, 6]
    space = 8
    res = find_max(w, v, space)
    print(res)
