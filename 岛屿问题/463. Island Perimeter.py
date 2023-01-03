from typing import List


class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        res = 0
        for row in range(0, len(grid)):
            for col in range(0, len(grid[0])):
                if grid[row][col] == 1:
                    for i, j in [[row - 1, col], [row + 1, col], [row, col - 1], [row, col + 1]]:
                        if (self.in_area(grid, i, j) and grid[i][j] == 0) or (not self.in_area(grid, i, j)):
                            res += 1
        return res

    def in_area(self, grid, row, col):
        return (row >= 0) and (row < len(grid)) and (col >= 0) and (col < len(grid[0]))


if __name__ == '__main__':
    cases = [
        [[0, 1, 0, 0], [1, 1, 1, 0], [0, 1, 0, 0], [1, 1, 0, 0]]
    ]

    for case in cases:
        print("case:", case)
        res = Solution().islandPerimeter(case)
        print("res:", res)
