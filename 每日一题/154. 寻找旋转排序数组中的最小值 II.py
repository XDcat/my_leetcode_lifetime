from typing import List

class Solution:
    def findMin(self, nums: List[int]) -> int:
        N = len(nums)
        lo = 0
        hi = N - 1
        while lo < hi:
            mid = (hi - lo) // 2 + lo
            if nums[hi] == nums[mid] == nums[lo]:
                lo += 1
                hi -= 1
            elif nums[hi] < nums[mid]:
                lo = mid + 1
            else:
                hi = mid 

        return nums[lo]


if __name__ == "__main__":
    nums = [1, 3, 5]
    # nums = [2, 2, 2, 0 ,1]
    # nums = [1, 3, 3, ]
    res = Solution().findMin(nums)
    print(res)
