# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/4/22
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''

from typing import List


class Solution:
    def maxSumSubmatrix(self, matrix: List[List[int]], k: int) -> int:

        col_len = len(matrix[0])
        res = matrix[0][0]
        for i in range(0, len(matrix)):
            # 行上限
            col_sum = [0] * col_len
            for j in range(i, len(matrix)):
                # 行 下限

                # 现在已经确定一个矩形了，压缩列
                for h in range(i, j + 1):
                    for l in range(col_len):
                        col_sum[l] += matrix[h][l]
                # 找出有限制的最大子序和
                # ！不是最大子序和，我们要求的是最靠近某一个值的，由于有负数的存在可能会使大值缩小，反而符合条件
                sub_set_sum = [col_sum[0]]
                for l in col_sum[1:]:
                    sub_set_sum.append(max(
                        l + sub_set_sum[-1], sub_set_sum[-1]
                    ))
                sub_set_sum = sorted(sub_set_sum, reverse=True)
                print(f"上限{i}, 下限{j}, 子序和 {sub_set_sum}")
                for l in sub_set_sum:
                    if l <= k:
                        res = max(res, l)
                        break
        return res


if __name__ == '__main__':
    matrix = [[1, 0, 1], [0, -2, 3]]
    k = 2
    matrix = [[2, 2, -1]]
    k = 3
    res = Solution().maxSumSubmatrix(matrix, k)
    print(res)
