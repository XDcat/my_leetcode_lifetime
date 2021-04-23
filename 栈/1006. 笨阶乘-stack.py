# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/4/1
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''


class Solution(object):
    def clumsy(self, N):
        """
        :type N: int
        :rtype: int
        """
        stack = [N, ]
        index = 0
        for i in range(N - 1, 0, -1):
            if index % 4 == 0:
                stack.append(stack.pop() * i)
            elif index % 4 == 1:
                stack.append(int(stack.pop() / i))
            elif index % 4 == 2:
                stack.append(i)
            else:
                stack.append(-i)
            index += 1
        return sum(stack)


if __name__ == '__main__':
    # print(Solution().clumsy(4))
    print(Solution().clumsy(10))
