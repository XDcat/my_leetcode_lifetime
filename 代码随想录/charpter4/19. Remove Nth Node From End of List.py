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
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
<<<<<<< HEAD
        pre_head = ListNode()
        pre_head.next = head
        
        slow = pre_head
        fast = pre_head
        for i in range(n):
            fast = fast.next
            if fast is None:
                return

        while fast.next:
            slow = slow.next
            fast = fast.next
        slow.next = slow.next.next
        return pre_head.next

=======
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
>>>>>>> 8fc7dc4beafcdbb8e36d5ff6e14d5a76e3622533


