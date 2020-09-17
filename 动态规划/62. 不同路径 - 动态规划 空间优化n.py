# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__mtime__ = 2020/9/16
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
"""

def count_path(m, n):
    """
    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
    问总共有多少条不同的路径？
    :param m: 行数 (其实是行还是列并不是很重要，两种是等效的)
    :param n: 列数
    :return: 问总共有多少条不同的路径？
    """
    # 动态规划
    cur = [1, ] * m  # 当前列
    # 由于递推公式是 dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
    # 从列的角度来看，只需要保存当前列和之前的一列，然后不断的更新
    # 如果我们只在当前行更新，这样就又可以节约空间
    for i in range(1, n):
        for j in range(1, m):
            cur[j] = cur[j] + cur[j - 1]
    return cur[-1]


if __name__ == '__main__':
    print(
        count_path(3, 7)
    )

