# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
"""


def heap_sort(lst):
    # build heap
    N = len(lst)
    for i in range(N // 2, 0, -1):
        sink(lst, i, N)

    # get the top value
    # exchange top and last, and sink top
    for i in range(N):
        exch(lst, 1, N)
        N -= 1
        sink(lst, 1, N)
    return lst


def sink(lst, i, n):
    while 2 * i <= n:
        j = 2 * i
        if j < n and less(lst, j, j + 1):
            j += 1
        if less(lst, j, i):
            break
        exch(lst, i, j)
        i = j


def exch(lst, i, j):
    lst[i - 1], lst[j - 1] = lst[j - 1], lst[i - 1]


def less(lst, i, j):
    return lst[i - 1] < lst[j - 1]


if __name__ == '__main__':
    l = [1, 23, 34, 0, 12, 1]
    res = heap_sort(l)
    print(res)
