# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
"""
from typing import List


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        self.aux(0, [], [], [], [], res, n)
        return res

    def aux(self, i, columns, diagonals1, diagonals2, m, res, n):
        """

        :param i: iteration
        :param columns: columns
        :param m: string matrix
        :param res: result
        :param n: target n
        :return:
        """
        if i == n:
            res.append(m[:])

        for j in range(n):
            diagonal1 = i - j
            diagonal2 = i + j
            if j not in columns and diagonal1 not in diagonals1 and diagonal2 not in diagonals2:
                # 设置状态
                # m
                col = [".", ] * n
                col[j] = "Q"
                m.append("".join(col))
                # 三个数组
                columns.append(j)
                diagonals1.append(diagonal1)
                diagonals2.append(diagonal2)

                self.aux(i + 1, columns, diagonals1, diagonals2, m, res, n)

                # 复原
                m.pop()
                columns.pop()
                diagonals1.pop()
                diagonals2.pop()


if __name__ == '__main__':
    cases = [4]
    s = Solution()
    for case in cases:
        res = s.solveNQueens(case)
        print(res)
