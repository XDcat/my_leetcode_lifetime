# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/3/11
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''


# class Solution:
#     def uniquePaths(self, m: int, n: int) -> int:
#         """
#         m 行，n列
#         """
#         result = [[1, ] * n for _ in range(m)]  # 构建结果矩阵，并初始化为 1
#         for i in range(1, m):
#             for j in range(1, n):
#                 result[i][j] = result[i][j - 1] + result[i - 1][j]
#         return result[-1][-1]

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        """
        m 行，n列
        """
        # result = [[1, ] * n for _ in range(m)]  # 构建结果矩阵，并初始化为 1
        result = [1, ] * n
        for i in range(1, m):
            for j in range(1, n):
                result[j] = result[j - 1] + result[j]
        return result[-1]

if __name__ == '__main__':
    print(Solution().uniquePaths(3, 7))
