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
l = [4, ]
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
        # 如果是最后一个，结束递归
        if (head.next is None) or (head is None):
            return head
        else:
            end_node = self.reverseList(head.next)  # 找到最后的节点
            # 调换当前节点和下一个节点的顺序
            head.next.next = head
            head.next = None

            return end_node

if __name__ == '__main__':
    print_link_list(head)
    head = Solution().reverseList(head)
    print_link_list(head)

