from typing import List
from collections import deque, defaultdict


class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        # 生成邻接表
        t = defaultdict(list)
        for i, j in edges:
            t[i].append(j)
            t[j].append(i)

        # BFS
        distance = []
        min_distance = float("inf")
        for root in range(n):
            # queue
            queue = deque()
            queue.append(root)
            # 标记是否访问过
            tag = [0] * n
            tag[root] = 1
            # 距离
            dis = -1
            while len(queue) > 0:
                dis += 1
                for _ in range(len(queue)):
                    node = queue.popleft()
                    for child in t[node]:
                        if tag[child] == 0:
                            tag[child] = 1
                            queue.append(child)
            distance.append(dis)
            min_distance = min(min_distance, dis)
        res = []
        for i in range(n):
            if distance[i] == min_distance:
                res.append(i)
        return res


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
