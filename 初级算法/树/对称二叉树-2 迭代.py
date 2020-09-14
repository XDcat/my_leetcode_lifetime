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
    def isSymmetric(self, root: TreeNode) -> bool:
        """
        迭代做法: 将递归修改为迭代
        某棵树对称，说明两颗子树是对称的，两颗子树对称意味着：
            1. 两个子树的值相等
            2. 左子树的左子树 == 右子树的右子树，左子树的右子树 == 右子树的左子树
        就可以发现一个递归，也就是将树的问题转化为两个子树的问题
        :param root:
        :return:
        """
        def check(left, right):
            """检查左右子树对称"""
            queue = list()
            queue.append(left)
            queue.append(right)
            while queue:
                left = queue.pop(0)
                right = queue.pop(0)

                if left is None and right is None:
                    continue
                if left is None or right is None:
                    return False
                if left.val != right.val:
                    return False

                queue.append(left.left)
                queue.append(right.right)

                queue.append(left.right)
                queue.append(right.left)
            return True

        return check(root, root)




if __name__ == '__main__':
    # 构造树
    vals = [1, 2, 2, 3, 4, 4, 3]
    i = 0
    btree = BinaryTree()
    for i in vals:
        btree.add(i)
    print(btree)
    print(Solution().isSymmetric(btree.root))
    print(btree)
