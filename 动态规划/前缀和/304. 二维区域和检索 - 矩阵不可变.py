# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/4/23
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''
from typing import List


class NumMatrix:

    def __init__(self, matrix: List[List[int]]):
        self.matrix = matrix
        self.sums = self.init()

    def init(self):
        row = len(self.matrix)
        col = len(self.matrix[0])
        _sums = [[0] * (col + 1) for _ in range(row + 1)]
        # _sums[i, j] = _sums[i - 1, j] + _sums[i, j - 1] - sums[i - 1, j - 1] + nums[i, j]
        for i in range(1, row + 1):
            for j in range(1, col + 1):
                _sums[i][j] = _sums[i - 1][j] + _sums[i][j - 1] - _sums[i - 1][j - 1] + self.matrix[i-1][j-1]
        return _sums

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        _sums = self.sums
        return _sums[row2 + 1][col2 + 1] - _sums[row1][col2 + 1] - _sums[row2 + 1][col1] + _sums[row1][col1]


if __name__ == '__main__':
    matrix = [
        [3, 0, 1, 4, 2],
        [5, 6, 3, 2, 1],
        [1, 2, 0, 1, 5],
        [4, 1, 0, 1, 7],
        [1, 0, 3, 0, 5]
    ]
    so = NumMatrix(matrix)
    print(so.sumRegion(2, 1, 4, 3))