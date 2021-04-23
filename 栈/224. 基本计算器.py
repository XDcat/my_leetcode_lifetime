# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/4/1
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''


class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        self.exp = []
        i = 0
        while i < len(s):
            if s[i] == " ":
                pass
            elif s[i] in "+*/":
                self.exp.append(i)
            else:
                while i < len(s) and s[i] == " ":
                    i += 1
                flag = 1 if s[i] != "-" else -1


        self.priority = {
            "(": - 1,
            ")": - 1,
            "+": 0,
            "-": 0,
            "*": 1,
            "/": 1,
            "%": 1,
            "^": 2,
        }
        return self.cal()

    def generate(self):
        stack = []
        post_exp = []
        for i in self.exp:
            if i not in self.priority and i not in "()":
                # 数字
                post_exp.append(i)
            else:
                # 运算符
                if len(stack) == 0:
                    stack.append(i)
                else:
                    if i == "(":
                        stack.append(i)
                    elif i == ")":
                        while stack[-1] != "(":
                            post_exp.append(stack.pop())
                        stack.pop()
                    else:
                        while len(stack) > 0 and self.priority[stack[-1]] >= self.priority[i]:
                            post_exp.append(stack.pop())
                        stack.append(i)
        while len(stack) > 0:
            post_exp.append(stack.pop())
        return post_exp

    def cal(self):
        post_exp = self.generate()
        stack = []
        for i in post_exp:
            if i in self.priority:
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
                elif i == "%":
                    vf = v2 % v1
                elif i == "^":
                    vf = v2 ** v1
                stack.append(vf)
            else:
                stack.append(int(i))

        return stack[0]


if __name__ == '__main__':
    s = " 2-1 + 2 "
    s = "(1+(4+5+2)-3)+(6+8)"
    s = "(1)"
    res = Solution().calculate(s)
    print(res)
