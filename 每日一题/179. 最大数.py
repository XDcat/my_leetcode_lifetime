from typing import List

from collections import defaultdict


class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        hash = [[] for _ in range(10)]
        for i in nums:
            hash[int(str(i)[0])].append(i)
        res = ""
        for i in hash[::-1]:
            res = res + "".join(map(str, sorted(i, reverse=True)))
        return res


if __name__ == '__main__':
    num = [3, 30, 34, 5, 9]
    print(Solution().largestNumber(num))
