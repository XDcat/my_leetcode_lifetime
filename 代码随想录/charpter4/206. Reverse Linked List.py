# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
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
