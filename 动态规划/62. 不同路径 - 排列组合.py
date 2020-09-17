# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__mtime__ = 2020/9/16
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
"""

import math
def count_path(m, n):
    """
    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
    问总共有多少条不同的路径？
    :param m: 列数
    :param n: 行数
    :return: 问总共有多少条不同的路径？
    """
    # 排列组合
    hi = n - 1
    lo = (n - 1) + (m - 1)
    res = math.factorial(lo) / math.factorial(hi) / math.factorial(lo - hi)
    return round(res)


if __name__ == '__main__':
    print(
        count_path(57, 2)
    )

