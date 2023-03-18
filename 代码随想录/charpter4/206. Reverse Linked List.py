<<<<<<< HEAD
# Definition for singly-linked list.
from typing import Optional


=======
# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2022/9/22
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''
from typing import Optional


# Definition for singly-linked list.
>>>>>>> 8fc7dc4beafcdbb8e36d5ff6e14d5a76e3622533
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
<<<<<<< HEAD
        cur = None
        nxt = head
        while nxt:
            tmp = nxt.next
            nxt.next = cur
            cur = nxt
            nxt = tmp
        return cur
class Solution2:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        return self.aux(None, head)
        pass
    def aux(self, pre, cur):
        if cur is None:
            return pre

        tmp = cur.next
        cur.next = pre
        pre = cur
        cur = tmp
        return self.aux(pre, tmp)
=======
        cur = head
        pre_head = None
        while cur is not None:
            nxt = cur.next
            cur.next = pre_head
            pre_head = cur
            cur = nxt
        return pre_head
>>>>>>> 8fc7dc4beafcdbb8e36d5ff6e14d5a76e3622533
