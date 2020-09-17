# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__mtime__ = 2020/9/16
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
"""

import time
def fib(n):
    results = list(range(n + 1))
    for i in range(n + 1):
        if i < 2:
            results[i] = i
        else:
            results[i] = results[i - 1] + results[i - 2]
    return results[-1]


if __name__ == '__main__':
    start_time = time.time()
    n = 10
    print("fib(%d) = " % n, fib(n))
    end_time = time.time()
    print("耗时: %f s" % ((end_time - start_time) / 1))
