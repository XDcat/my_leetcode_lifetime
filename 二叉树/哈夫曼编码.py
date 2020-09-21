# -*- coding:utf-8 -*-
"""
__author__ = 'XD'
__mtime__ = 2020/9/18
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
"""


class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
    def __str__(self):
        return self.val

def huffman_encode(d):
    items = d.items()
    items = [[TreeNode(i[0]), i[1]] for i in items]
    items = sorted(items, key=lambda x: x[1])  # 排序
    # 生成树
    while len(items) > 1:
        n1 = items.pop(0)
        n2 = items.pop(0)
        current_node_weight = TreeNode(None)
        current_node_weight.left = n1[0]
        current_node_weight.right = n2[0]
        items.append([current_node_weight, n1[1] + n2[1]])
        items = sorted(items, key=lambda x: x[1])
    head = items[0][0]  # 根节点
    # 编码
    res = {}

    def helper(node, code):
        if node is not None:
            if node.val is not None:
                res[node.val] = code
            helper(node.left, code + "0")
            helper(node.right, code + "1")
    helper(head, "")
    return res


if __name__ == '__main__':
    d = dict(zip(
        list("abcdefgh"), [6, 30, 8, 9, 15, 24, 4, 12]
    ))
    print(d)  # {'a': 6, 'b': 30, 'c': 8, 'd': 9, 'e': 15, 'f': 24, 'g': 4, 'h': 12}
    print(huffman_encode(d))  # {'g': '0000', 'a': '0001', 'h': '001', 'f': '01', 'b': '10', 'e': '110', 'c': '1110', 'd': '1111'}
