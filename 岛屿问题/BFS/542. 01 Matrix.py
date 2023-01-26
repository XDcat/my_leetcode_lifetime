from typing import List
from collections import deque


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        n_row = len(mat)
        n_col = len(mat[0])

        res = [[0] * n_col for _ in range(n_row)]
        move = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        for row in range(0, n_row):
            for col in range(0, n_col):
                tag = [[0] * n_col for _ in range(n_row)]  # 判断是否访问过
                queue = deque()  # BFS
                queue.append((row, col))
                distance = -1  # 距离
                flag = False  # 停止的标志
                while len(queue) > 0:
                    if flag:
                        break
                    distance += 1
                    for _ in range(len(queue)):
                        row1, col1 = queue.popleft()
                        if mat[row1][col1] == 0:
                            flag = True
                            res[row][col] = distance
                            break
                        for i, j in move:
                            row2 = row1 + i
                            col2 = col1 + j
                            if self.in_area(mat, row2, col2) and tag[row2][col2] == 0:
                                tag[row2][col2] = 1
                                queue.append((row2, col2))
        return res

    def in_area(self, mat, row, col):
        return (row >= 0) and (row < len(mat)) and (col >= 0) and (col < len(mat[0]))


if __name__ == '__main__':
    cases = [
        [[0], [1]],
        [[0, 0, 0], [0, 1, 0], [0, 0, 0]],
        [[0, 0, 0], [0, 1, 0], [1, 1, 1]]
    ]
    for case in cases:
        print("case:", case)
        res = Solution().updateMatrix(case)
        print("res:", res)
