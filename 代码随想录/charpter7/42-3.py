from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        """单调队列"""
        stack = [0]
        res = 0
        for i in range(1, len(height)):
            # if height[i] < height[stack[-1]]:
            #     stack.append(i)
            # elif i == stack[-1]:
            #     stack.pop()
            #     stack.append(i)
            # else:
            while len(stack) > 0 and height[i] > height[stack[-1]]:
                right = height[i]
                mid = height[stack.pop()]
                if len(stack) > 0:
                    left = height[stack[-1]]
                    res += (min(right, left) - mid) * (i - stack[-1] - 1)
                    # print(i, ":", left, mid, right, "->", stack)
            stack.append(i)
            # print(i, ":", stack)
        return res


if __name__ == '__main__':
    cases = [
        [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1],
        [4, 2, 0, 3, 2, 5]
    ]
    for case in cases:
        print("case:", case)
        res = Solution().trap(case)
        print("result:", res)
        print()
