class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        map = dict()
        for i, j in enumerate(nums):
            partition = target - j  # 计算差值
            if partition in map.keys():
                return map[partition], i
            map[j] = i


res = Solution().twoSum(
    [2, 7, 11, 15],
    9
)
print(res)