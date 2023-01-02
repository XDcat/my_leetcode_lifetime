from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        """双指针法"""
        res = 0
        for i in range(1, len(height) - 1):
            mid_hight = height[i]
            l_hight = r_hight = mid_hight

            # 左侧
            j = i
            while j >= 0:
                l_hight = max(l_hight, height[j])
                j -= 1

            # 右侧
            j = i
            while j < len(height):
                r_hight = max(r_hight, height[j])
                j += 1

            # print(l_hight, "->", mid_hight, "<-", r_hight)
            res += min(l_hight, r_hight) - mid_hight

        return res


if __name__ == '__main__':
    cases = [
        # [0,1,0,2,1,0,1,3,2,1,2,1],
        [4,2,0,3,2,5]
    ]
    for case in cases:
        res = Solution().trap(case)
        print("case:", case)
        print("result:", res)
        print()