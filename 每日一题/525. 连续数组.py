# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2021/6/3
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''


from typing import List
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        """超时
        # 计算前缀和
        preSum = [0]
        for i in nums:
            preSum.append(preSum[-1] + i)

        # 间隔为 2 的倍数，从大到小遍历
        # 如果和为间隔的一半，则停止
        for interval in range(len(nums) // 2 * 2, 2-1, -2):
            # 起点
            for start in range(0, len(nums) - interval + 1):
                # 终点
                end = start + interval -1
                t = preSum[end + 1] - preSum[start]
                if t == interval / 2:
                    return interval
        return 0
        """

        """
        前缀和：在这里并不是使用前缀和计算某一段区间的和，而是利用了减法的性质，当两个和相同时，中间区间的和一定为0 
        相比于前一个方法，这里只需要一次遍历。其实与昨天的题目有很大的相似之处。
        """
        counter = 0
        hashMap = {0: -1, }
        ans = 0
        for i, v in enumerate(nums):
            counter = counter + (v if v == 1 else -1)
            if counter in hashMap:
                preIndex = hashMap[counter]
                ans = max(ans, i - preIndex)
            else:
                hashMap[counter] = i
        return ans





if __name__ == '__main__':
    res = Solution().findMaxLength(
        [0, 1]
    )
    print(res)