# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/4/1
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''


class PostfixExpression:
    def __init__(self, exp):
        self.exp = list(exp)
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

    def calculate(self):
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
                stack.append(i)

        return stack[0]


if __name__ == '__main__':
    exp = []
    exp.append("(A+B)*(C-D)/E+G/H")
    exp.append("a+d*(b-c)")
    exp.append("(A+B)*(C-D)/E^F+G%H")
    for i in exp:
        print(PostfixExpression(i).generate())

    e1 = list("(1+4)*(10-6)/2^2+3%2")
    print(PostfixExpression(e1).calculate())
