# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/4/1
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''
from typing import List
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        """
        :type tokens: List[str]
        :rtype: int
        """
        post_exp = tokens
        stack = []
        for i in post_exp:
            if i in "+-*/":
                v1 = int(stack.pop())
                v2 = int(stack.pop())
                if i == "+":
                    vf = v2 + v1
                elif i == "-":
                    vf = v2 - v1
                elif i == "*":
                    vf = v2 * v1
                elif i == "/":
                    vf = v2 / v1
                stack.append(vf)
            else:
                stack.append(int(i))

        return int(stack[0])


if __name__ == '__main__':
    tokens = ["2", "1", "+", "3", "*"]
    tokens = ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
    tokens = ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
    print(Solution().evalRPN(tokens))
