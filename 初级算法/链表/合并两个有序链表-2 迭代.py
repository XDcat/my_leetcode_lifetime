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
    def __str__(self):
        return "%s -> %s" % (self.val, self.next)

# 输出链表
def print_link_list(head):
    node = head
    print("[", end="")
    while node != None:
        print(node.val, "->", end="", sep="")
        node = node.next
    print("None]")

# 创建链表
l = [1, 2, 5, 8]
head = ListNode(l[0])
node = head
for i in l[1:]:
    node.next = ListNode(i)
    node = node.next

# 创建链表
l1 = [3, 4, 5, 6, 7]
head1 = ListNode(l1[0])
node = head1
for i in l1[1:]:
    node.next = ListNode(i)
    node = node.next
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        prehead = ListNode(0)  # 哑节点

        prev = prehead  # 维护结果链上的节点
        while l1 is not None and l2 is not None:
            if l1.val < l2.val:
                prev.next = l1
                l1 = l1.next
            else:
                prev.next = l2
                l2 = l2.next
            prev = prev.next

        prev.next = l1 if l2 is None else l2
        return prehead.next

if __name__ == '__main__':
    print_link_list(head)
    print_link_list(head1)
    head = Solution().mergeTwoLists(head, head1)
    print_link_list(head)

