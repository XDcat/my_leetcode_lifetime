from typing import List

from collections import deque


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        count = 0
        queue = deque()
        for row in range(m):
            for col in range(n):
                if grid[row][col] == 0:
                    count += 1
                elif grid[row][col] == 2:
                    count += 1
                    queue.append((row, col))

        t = -1
        move = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        while len(queue) > 0:
            t += 1
            for _ in range(len(queue)):
                row, col = queue.popleft()
                for i, j in move:
                    row2, col2 = row + i, col + j
                    if self.in_area(grid, row2, col2) and grid[row2][col2] == 1:
                        count += 1
                        grid[row2][col2] = 2
                        queue.append((row2, col2))

        if count == m*n:
            return max(t, 0)
        else:
            return -1

    def in_area(self, grid, row, col):
        return (0 <= row < len(grid)) and (0 <= col < len(grid[0]))


if __name__ == '__main__':
    cases = [
        [[0]],
        [[2, 1, 1], [1, 1, 0], [0, 1, 1]],
        [[2, 1, 1], [0, 1, 1], [1, 0, 1]],
        [[0, 2]]
    ]

    for case in cases:
        print("case:", case)
        res = Solution().orangesRotting(case)
        print("res:", res)
