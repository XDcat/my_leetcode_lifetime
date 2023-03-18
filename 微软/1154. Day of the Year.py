# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2022/9/23
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''


class Solution:
    def __init__(self):
        self.days1 = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]  # normal
        self.days2 = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]  # special
        self.pre1 = self.cal_pre(self.days1)
        self.pre2 = self.cal_pre(self.days2)

    def is_special_year(self, year):
        if (year % 4 == 0) and ((year % 100 != 0) or (year % 400 == 0)):
            return True
        else:
            return False

    def cal_pre(self, lst):
        res = [0, ]
        for i in lst:
            res.append(res[-1] + i)
        assert len(res) == 13
        return res

    def dayOfYear(self, date: str) -> int:
        # get nums
        try:
            nums = date.split("-")
            nums = map(int, nums)
            year, month, day = nums
        except Exception as e:
            return -1

        # check nums
        # year
        if year < 0:
            return -1
        # mouth
        if month < 0 or month > 12:
            return -1
        # day
        days = self.days2 if self.is_special_year(year) else self.days1
        if day < 0 or days[month]:
            return -1

        # cal days
        pre = self.pre2 if self.is_special_year(year) else self.pre1
        return pre[month - 1] + day


if __name__ == '__main__':
    s = Solution()
    print(s.dayOfYear("2003-02-040"))
