# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2022/9/12
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''
from typing import List


class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        res = [[0] * n for _ in range(n)]
        num = 1
        i = 0
        j = 0
        length = n - 1
        while length > 0:
            # 从左到右
            for k in range(length):
                res[i][j] = num
                num = num + 1
                j = j + 1

            # 从上到下
            for k in range(length):
                res[i][j] = num
                num = num + 1
                i = i + 1

            # 从右往左
            for k in range(length):
                res[i][j] = num
                num = num + 1
                j = j - 1

            # 从下到上
            for k in range(length):
                res[i][j] = num
                num = num + 1
                i = i - 1

            i = i + 1
            j = j + 1
            length = length - 2
        if length == 0:
            res[i][j] = num
        return res


if __name__ == '__main__':
    s = Solution()
    for j in range(1, 6):
        print(f"------{j}------")
        res = s.generateMatrix(j)
        for i in res:
            print(i)
