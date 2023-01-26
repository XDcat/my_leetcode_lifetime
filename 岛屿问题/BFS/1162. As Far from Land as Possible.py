from typing import List
from collections import deque


class Solution:
    def maxDistance(self, grid: List[List[int]]) -> int:
        queue = deque()
        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if grid[row][col] == 1:
                    queue.append((row, col))

        if len(queue) == 0 or len(queue) == len(grid) * len(grid[0]):
            return -1
        distance = -1
        move = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        while len(queue) > 0:
            distance += 1
            for _ in range(len(queue)):
                row, col = queue.popleft()
                for i, j in move:
                    row2 = row + i
                    col2 = col + j
                    if self.in_area(grid, row2, col2) and grid[row2][col2] == 0:
                        grid[row2][col2] = 2
                        queue.append((row2, col2))

        return distance

    def in_area(self, grid, row, col):
        return (row >= 0) and (row < len(grid)) and (col >= 0) and (col < len(grid[0]))


if __name__ == '__main__':
    cases = [
        [[1, 0, 1], [0, 0, 0], [1, 0, 1]],
        [[1, 1, 1, 1, 1], [1, 1, 1, 1, 1], [1, 1, 1, 1, 1], [1, 1, 1, 1, 1], [1, 1, 1, 1, 1]],
        [[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]]
    ]
    for case in cases:
        print("case:", case)
        res = Solution().maxDistance(case)
        print("res:", res)
