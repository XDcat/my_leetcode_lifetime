# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/3/31
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''


class Solution(object):
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """

        def tracebacking(res, t, d, n, cur):
            """

            :param res: 最终的结果
            :param t: 暂存结果的列表
            :param d: 深度
            :param n: 传入的数组
            :param cur: 当前值
            :return:
            """
            if d == k:
                res.append(t[:])
                return
            for i in range(cur, len(n)):
                t.append(n[i])
                tracebacking(res, t, d + 1, n, i + 1)
                t.pop()
            return

        res = []
        t = []
        tracebacking(res, t, 0, [i for i in range(1, n + 1)], 0)
        return res


if __name__ == '__main__':
    res = Solution().combine(4, 2)
    print(res)
