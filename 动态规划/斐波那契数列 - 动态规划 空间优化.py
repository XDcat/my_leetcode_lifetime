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

    p, q, r = 0, 0, 1
    for i in range(2, n + 1):
        p, q = q, r
        r = p + q
    return r


if __name__ == '__main__':
    start_time = time.time()
    for i in range(10):
        n = i
        print(fib(n))
    end_time = time.time()
    print("耗时: %f s" % ((end_time - start_time) / 1))
