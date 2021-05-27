# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/5/21
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''
from typing import List


class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        letterMap = {"2": "abc", "3": "def", "4": "ghi", "5": "jkl", "6": "mno", "7": "pqrs", "8": "tuv", "9": "wxyz", }

        def backtracking(t, cur):
            if len(cur) == 0:
                if t:
                    res.append(t[:])
                return

            for i in letterMap[cur[0]]:
                t += i
                backtracking(t, cur[1:])
                t = t[: -1]

        res = []
        backtracking("", digits)
        return res


if __name__ == '__main__':
    digits = "23"
    res = Solution().letterCombinations(digits)
    print(res)
