# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/3/11
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''

import time


def solve1(n):
    if n < 2:
        return n
    else:
        return solve1(n - 1) + solve1(n - 2)


def solve2(n):
    if n <= 2:
        return 1
    else:
        l = [1, 1]
        for i in range(2, n):
            l.append(l[-1] + l[-2])
        return l[-1]


def solve3(n):
    if n <= 2:
        return 1
    else:
        n1, n2 = 1, 1
        for i in range(2, n):
            n1, n2 = n2, n1 + n2
        return n2


if __name__ == '__main__':
    stime = time.time()
    r = solve1(40)
    etime = time.time()
    t = etime - stime
    print(f"递归需要的时间{t}, 结果{r}")

    stime = time.time()
    r = solve2(40)
    etime = time.time()
    t = etime - stime
    print(f"动态规划需要的时间{t}, 结果{r}")

    stime = time.time()
    r = solve3(40)
    etime = time.time()
    t = etime - stime
    print(f"动态规划(空间优化)需要的时间{t}, 结果{r}")
