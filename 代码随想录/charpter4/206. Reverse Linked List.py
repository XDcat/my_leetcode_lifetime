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
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        cur = head
        pre_head = None
        while cur is not None:
            nxt = cur.next
            cur.next = pre_head
            pre_head = cur
            cur = nxt
        return pre_head
