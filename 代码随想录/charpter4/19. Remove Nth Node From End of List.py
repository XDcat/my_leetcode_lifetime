# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2022/9/22
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''
from typing import Optional


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        vhead = ListNode(0, head)
        low = vhead
        fast = vhead
        i = 0
        while i < n and fast is not None:
            fast = fast.next
            i = i + 1

        # size < n
        if fast is None:
            return vhead.next

        while fast.next is not None:
            low = low.next
            fast = fast.next

        low.next = low.next.next
        return vhead.next


