# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2020/9/13
__project__ = leetcode 刷题
Fix the Problem, Not the Blame.
'''
from queue import Queue, LifoQueue, PriorityQueue


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    def __str__(self):
        return str(self.val)


# 构造二叉树
class BinaryTree:
    def __init__(self, root=None):
        self.root = root

    def add(self, val):
        node = TreeNode(val)
        if self.root is None:
            self.root = node
        else:
            queue = list()
            queue.append(self.root)
            while queue:
                # 出队
                current = queue.pop(0)
                if current.left is None:
                    current.left = node
                    return
                elif current.right is None:
                    current.right = node
                    return
                else:
                    # 在队列中加入左右节点，继续遍历
                    queue.append(current.left)
                    queue.append(current.right)

    def __str__(self):
        res_str = []
        if self.root is None:
            res_str.append("null")
        else:
            # 广度遍历
            q = Queue()  # 无界队列
            q.put(self.root)
            while not q.empty():
                node = q.get()
                res_str.append(node.val)
                if node.left is not None:
                    q.put(node.left)
                if node.right is not None:
                    q.put(node.right)

        res_str = map(str, res_str)
        return " ".join(res_str)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        def helper(node, lower=float("-inf"), upper=float("inf")):
            # 如果为空直接返回
            if not node:
                return True
            # 比较区间
            val = node.val
            if val <= lower or val >= upper:
                return False
            # 比较子节点
            if not helper(node.left, lower, val):
                return False
            if not helper(node.right, val, upper):
                return False
            # 默认返回真
            return True

        return helper(root)











if __name__ == '__main__':
    # 构造树
    vals = [3, 9, 20, None, None, 15, 7]
    i = 0
    btree = BinaryTree()
    for i in vals:
        btree.add(i)
    print(btree)

    print(btree)
