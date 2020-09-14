class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: None Do not return anything, modify matrix in-place instead.
        """
        # 对角线翻转
        N = len(matrix)
        for i in range(N):
            for j in range(i + 1):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]

        # 水平翻转
        for i in range(N):
            for j in range(N // 2):
                matrix[i][j], matrix[i][N - 1 - j]  = matrix[i][N - 1 - j], matrix[i][j]

matrix = [
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
]
Solution().rotate(matrix)
for i in matrix:
    print(i)
