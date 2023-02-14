# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
from typing import Optional, List


class Solution:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        res = self.dfs(root)
        return res

    def dfs(self, root: TreeNode):
        if root is None:
            return []

        l_path = self.dfs(root.left)
        r_path = self.dfs(root.right)
        if len(l_path) + len(r_path) == 0:
            return ["{}".format(root.val)]

        cur_path = []
        for p in l_path + r_path:
            if p:
                cur_path.append("{}->{}".format(root.val, p))
            else:
                cur_path.append("{}".format(root.val))
        return cur_path

