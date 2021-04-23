# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/4/3
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''


class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        # dp[i][j] 表示text取前 i 个字符，test2 取前 j 个字符时，最大的长度
        # i <- 0 ... len(text1) 行
        # j <- 0 ... len(text2) 列
        text1 = " " + text1
        text2 = " " + text2
        dp = [[0] * (len(text2)) for _ in range(len(text1))]
        for i in range(1, len(text1)):
            for j in range(1, len(text2)):
                if text1[i] == text2[j]:
                    dp[i][j] = dp[i - 1][j - 1] + 1
                else:
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

        return dp[-1][-1]


if __name__ == '__main__':
    text1 = "abcde"
    text2 = "ace"
    res = Solution().longestCommonSubsequence(text1, text2)
    print(res)
