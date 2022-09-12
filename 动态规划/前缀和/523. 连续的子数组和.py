from typing import List


class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        """特殊的前缀和
        前缀和，便于计算连续的子集的和。
        整除的特殊性，当前缀和的余数相同时，便可以整除。
        """
        hashMap = {0: -1}
        reminder = 0
        for i, v in enumerate(nums):
            reminder = (reminder + v) % k
            if reminder in hashMap:
                preIndex = hashMap[reminder]
                if i - preIndex >= 2:
                    return True
            else:
                hashMap[reminder] = i

        return False


if __name__ == "__main__":
    nums = [23, 2, 4, 6, 7]
    k = 6
    res = Solution().checkSubarraySum(nums, k)
    print(res)
