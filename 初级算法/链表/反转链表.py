# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2020/9/12
__project__ = leetcode 刷题
Fix the Problem, Not the Blame.
'''

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

# 输出链表
def print_link_list(head):
    node = head
    print("[", end="")
    while node != None:
        print(node.val, "->", end="", sep="")
        node = node.next
    print("None]")

# 创建链表
l = [4, 5, 1, 9]
head = ListNode(l[0])
node = head
for i in l[1:]:
    node.next = ListNode(i)
    node = node.next
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if head is None:
            return
        node = head
        next_node = node.next
        node.next = None

        while next_node is not None:
            next_next_node = next_node.next
            next_node.next = node
            node, next_node = next_node, next_next_node
        return node

if __name__ == '__main__':
    print_link_list(head)
    head = Solution().reverseList(head)
    print_link_list(head)

