from typing import List
from collections import deque, defaultdict


class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        graph = [[] for _ in range(n)]
        for i, j in edges:
            graph[i].append(j)
            graph[j].append(i)

        parent = [n] * n
        x = self.BFS(0, graph, parent, n)
        y = self.BFS(x, graph, parent, n)
        pth = []
        parent[x] = -1
        while y != -1:
            pth.append(y)
            y = parent[y]

        # print(pth)
        if len(pth) % 2 == 1:
            return [pth[(len(pth) - 1) // 2], ]
        else:
            return [pth[len(pth) // 2], pth[len(pth) // 2 - 1]]

    def BFS(self, root, g, parent, n):
        queue = deque()
        queue.append(root)
        tag = [0] * n
        tag[root] = 1
        while len(queue) > 0:
            for _ in range(len(queue)):
                node = queue.popleft()
                for child in g[node]:
                    if tag[child] == 0:
                        tag[child] = 1
                        parent[child] = node
                        queue.append(child)
        return node


if __name__ == '__main__':
    cases = [
        [4, [[1, 0], [1, 2], [1, 3]]],
        [6, [[3, 0], [3, 1], [3, 2], [3, 4], [5, 4]]],
    ]
    for case in cases:
        print("case:", case)
        res = Solution().findMinHeightTrees(*case)
        print("res:", res)
        print("*-" * 10)
