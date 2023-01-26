from typing import List


class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        # cal area
        areas = {}
        area_index = 2
        for row in range(0, len(grid)):
            for col in range(0, len(grid[0])):
                if grid[row][col] == 1:
                    a = self.area(grid, row, col, area_index)
                    areas[area_index] = a
                    area_index += 1

        # # find max area
        # if len(areas) == 0:
        #     return 0
        #
        res = 0
        for row in range(0, len(grid)):
            for col in range(0, len(grid[0])):
                if grid[row][col] == 0:
                    res = max(res, self.fill_island(grid, row, col, areas))
        if res == 0:
            res = max(areas.values())
        return res

    def fill_island(self, grid, row, col, areas):
        islands = []
        for i, j in [(row - 1, col), (row + 1, col), (row, col - 1), (row, col + 1)]:
            if self.in_area(grid, i, j) and grid[i][j] not in islands and grid[i][j] != 0:
                islands.append(grid[i][j])

        a = 1
        for i in islands:
            a += areas[i]
        return a

    def in_area(self, grid, row, col):
        return (row >= 0) and (row < len(grid)) and (col >= 0) and (col < len(grid[0]))

    def area(self, grid, row, col, index):
        if not self.in_area(grid, row, col):
            return 0

        if grid[row][col] != 1:
            return 0

        grid[row][col] = index

        return 1 \
               + self.area(grid, row - 1, col, index) \
               + self.area(grid, row + 1, col, index) \
               + self.area(grid, row, col - 1, index) \
               + self.area(grid, row, col + 1, index)


if __name__ == '__main__':
    cases = [
        [[1, 0], [0, 1]],
        [[1, 1], [1, 0]],
        [[1, 1], [1, 1]],
        [[0, 0], [0, 0]],
    ]

    for case in cases:
        print("case:", case)
        res = Solution().largestIsland(case)
        print("res:", res)
