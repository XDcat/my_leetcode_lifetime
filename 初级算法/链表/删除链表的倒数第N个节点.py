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


class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        dummy = ListNode(0)  # 哑节点
        dummy.next = head
        node = dummy
        front = dummy  # 探索节点
        # 开始探索
        for i in range(n):
            front = front.next

        # 一起探索
        while front.next is not None:
            node = node.next
            front = front.next

        # 消除当前节点
        node.next = node.next.next
        return dummy.next

# 输出链表
def print_link_list(head):
    node = head
    print("[", end="")
    while node != None:
        print(node.val, "->", end="", sep="")
        node = node.next
    print("None]")


# 创建链表
l = [9]
head = ListNode(l[0])
node = head
for i in l[1:]:
    node.next = ListNode(i)
    node = node.next

if __name__ == '__main__':
    print_link_list(head)
    head = Solution().removeNthFromEnd(head, 1)
    print_link_list(head)
