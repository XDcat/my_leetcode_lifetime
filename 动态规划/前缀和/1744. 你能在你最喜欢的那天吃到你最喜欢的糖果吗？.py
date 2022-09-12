# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/6/2
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''
from typing import List


class Solution:
    def canEat(self, candiesCount: List[int], queries: List[List[int]]) -> List[bool]:
        """前缀和
        对于 queries 中的某一个元素，希望在第 querise[i][1] 天吃到第 queries[i][0] 种类型的糖，
        限制条件是每天吃 1 ~ querise[i][2] 颗糖，
        所以，我们只需要计算吃到第 queriese[i][0] 颗糖的时间范围或者在第  querise[i][1] 天吃到的糖的类型的范围。
        """
        # 前序和：第 i 类糖前面有多少的糖
        preSum = [0, ]
        for i in candiesCount:
            preSum.append(preSum[-1] + i)
        res = []
        """1. 计算时间范围"""
        for t, d, interval in queries:
            d = d
            # 最快时间
            htime = preSum[t] // interval  # 刚刚开始吃到当前的糖
            # 最慢时间
            ltime = preSum[t + 1] - 1  # 吃完所有当前的糖
            # print(t, d, interval, htime, ltime)
            if htime <= d <= ltime:
                res.append(True)
            else:
                res.append(False)
        return res

        """2. 计算糖的范围  不太好做!"""
        # for t, d, interval in queries:
        #     # 在 d 天，吃到糖的种类
        #     # 最小种类 每天吃 1 颗糖
        #     min_c = (d + 1)
        #     # 最大种类 每天吃 interval 颗糖
        #     max_c = (d + 1) * interval
        #     # 具体需要遍历前序和
        #     if max_c > preSum[-1]:
        #         res.append(False)
        #         continue
        #     min_type = -1
        #     max_type = len(candiesCount)
        #     for i, v in enumerate(preSum):
        #         if v > min_c and min_type == -1:
        #             min_type = i - 1
        #         if v > max_c:
        #             max_type = i - 1
        #             break
        #     if min_type <= t <= max_type:
        #         res.append(True)
        #     else:
        #         res.append(False)
        # return res


if __name__ == '__main__':
    res = Solution().canEat(
        [5, 2, 6, 4, 1],
        [[3, 1, 2], [4, 10, 3], [3, 10, 100], [4, 100, 30], [1, 3, 1]]
    )
    print(res)
