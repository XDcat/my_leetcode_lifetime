# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        res = self.dfs(root)
        return res >= 0

    def dfs(self, node: TreeNode):
        if node is None:
            return 0

        # TODO: 这里还可以剪枝 -> check after lh or rh, not lh and rh
        lh = self.dfs(node.left)
        rh = self.dfs(node.right)

        if -1 in [lh, rh]:
            return -1

        if abs(lh - rh) > 1:
            return -1
        else:
            return 1 + max(lh, rh)
