from typing import List
from collections import deque


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        n_row, n_col = len(mat), len(mat[0])

        res = [[0] * n_col for _ in range(n_row)]  # result，默认 0 的距离为 0
        tag = [[-1] * n_col for _ in range(n_row)]  # 标记是否被访问过, -1 表示没有访问过
        queue = deque()  # BFS
        for row in range(n_row):
            for col in range(n_col):
                if mat[row][col] == 0:
                    tag[row][col] = 0  # 已经访问
                    queue.append((row, col))  # 标记所有 0

        # BFS
        move = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        while len(queue) > 0:
            for _ in range(len(queue)):
                row, col = queue.popleft()
                for i, j in move:
                    row2 = row + i
                    col2 = col + j
                    if self.in_area(mat, row2, col2) and tag[row2][col2] == -1:
                        # 寻找范围内，没有访问过的节点
                        res[row2][col2] = res[row][col] + 1  # 设置最近距离（类似 DP ）
                        tag[row2][col2] = 1  # 已经访问过
                        queue.append((row2, col2))
        return res

    def in_area(self, mat, row, col):
        return (row >= 0) and (row < len(mat)) and (col >= 0) and (col < len(mat[0]))


if __name__ == '__main__':
    cases = [
        [[0, 0, 0], [0, 1, 0], [1, 1, 1]],
        [[0], [1]],
        [[0, 0, 0], [0, 1, 0], [0, 0, 0]],
    ]
    for case in cases:
        print("case:", case)
        res = Solution().updateMatrix(case)
        print("res:", res)
