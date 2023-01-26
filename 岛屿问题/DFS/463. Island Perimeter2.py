from typing import List


class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        res = 0
        for row in range(0, len(grid)):
            for col in range(0, len(grid[0])):
                if grid[row][col] == 1:
                    res += self.perimeter(grid, row, col)
        return res

    def in_area(self, grid, row, col):
        return (row >= 0) and (row < len(grid)) and (col >= 0) and (col < len(grid[0]))

    def perimeter(self, grid, row, col):
        if not self.in_area(grid, row, col):
            return 1

        if grid[row][col] == 0:
            return 1

        if grid[row][col] != 1:
            return 0

        grid[row][col] = 2
        return self.perimeter(grid, row - 1, col) \
               + self.perimeter(grid, row + 1, col) \
               + self.perimeter(grid, row, col - 1) \
               + self.perimeter(grid, row, col + 1)


if __name__ == '__main__':
    cases = [
        [[0, 1, 0, 0], [1, 1, 1, 0], [0, 1, 0, 0], [1, 1, 0, 0]]
    ]

    for case in cases:
        print("case:", case)
        res = Solution().islandPerimeter(case)
        print("res:", res)
