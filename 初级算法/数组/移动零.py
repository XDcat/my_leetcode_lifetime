class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        nums_of_zero = 0
        for i in range(len(nums)):
            if (nums[i]) == 0:
                nums_of_zero += 1
            else:
                nums[i - nums_of_zero] = nums[i]
        for i in range(nums_of_zero):
            nums[len(nums) - 1 - i] = 0


nums = [0,1,0,3,12]
Solution().moveZeroes(nums)
print(nums)