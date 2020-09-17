# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__mtime__ = 2020/9/16
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
"""


# The isBadVersion API is already defined for you.
# @param version, an integer
# @return a bool
# def isBadVersion(version):


def isBadVersion(mid):
    if mid >= 4:
        return True
    else:
        return False





if __name__ == '__main__':
    print(Solution().firstBadVersion(10))
