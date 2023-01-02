from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        """动态规划"""
        # 类似前缀和，找到左右的最大值
        l_max_height = [0, ]
        for i in height:
            l_max_height.append(max(i, l_max_height[-1]))
        l_max_height = l_max_height[1:]

        r_max_height = [0, ]
        for i in height[::-1]:
            r_max_height.append(max(i, r_max_height[-1]))
        r_max_height = r_max_height[1:]
        r_max_height = r_max_height[::-1]

        res = 0
        for i in range(1, len(height) - 1):
            # print(l_max_height[i], height[i], r_max_height[i])
            res += min(l_max_height[i], r_max_height[i]) - height[i]

        return res

if __name__ == '__main__':
    cases = [
        [0,1,0,2,1,0,1,3,2,1,2,1],
        [4,2,0,3,2,5]
    ]
    for case in cases:
        res = Solution().trap(case)
        print("case:", case)
        print("result:", res)
        print()