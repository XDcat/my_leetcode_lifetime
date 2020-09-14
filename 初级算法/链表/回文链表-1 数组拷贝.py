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
l = [4, 5, 1, 9]
l = [1, 2, 2, 1]
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
    def isPalindrome(self, head: ListNode) -> bool:
        l = []
        while head is not None:
            l.append(head.val)
            head = head.next
        return l == l[::-1]


if __name__ == '__main__':
    print_link_list(head)
    print(Solution().isPalindrome(head))
    print_link_list(head)
