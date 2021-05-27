# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/5/27
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''


class Solution:
    def hammingDistance(selfself, x: int, y: int) -> int:
        t = x ^ y
        res = 0
        while t > 0:
            if t & 1 == 1:
                res += 1
            t = t >> 1
        return res

if __name__ == '__main__':
    res = Solution().hammingDistance(1, 4)
    print(res)