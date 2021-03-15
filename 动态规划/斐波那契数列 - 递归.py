# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__mtime__ = 2020/9/16
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
"""

import time


def fib(n):
    if n < 2:
        return n
    else:
        return fib(n - 1) + fib(n - 2)


if __name__ == '__main__':
    start_time = time.time()
    n = 40
    print("fib(%d) = " % n, fib(n))
    end_time = time.time()
    print("耗时: %f s" % ((end_time - start_time) / 1))
