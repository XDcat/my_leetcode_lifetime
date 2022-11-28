from typing import List


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        self.aux(0, [], [], res, n)
        return res

    def aux(self, i, j_exits, m, res, n):
        if i == n:
            res.append(m[:])

        for j in range(n):
            if j not in j_exits:
                # 判断斜线
                flag = True
                for k in range(0, len(j_exits)):
                    if j_exits[- k - 1] in [j - 1 - k, j + 1 + k]:
                        flag = False
                        break

                if flag:
                    # 设置状态
                    # m
                    col = [".", ] * n
                    col[j] = "Q"
                    m.append("".join(col))
                    # j_exits
                    j_exits.append(j)

                    self.aux(i + 1, j_exits, m, res, n)

                    # 复原
                    m.pop()
                    j_exits.pop()


if __name__ == '__main__':
    cases = [4, ]
    s = Solution()
    for case in cases:
        res = s.solveNQueens(case)
        print(res)
        for i in res:
            print("\n".join(i))
            print("=============================================")
