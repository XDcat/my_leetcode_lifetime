# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2022/9/13
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''
# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        vhead = head


