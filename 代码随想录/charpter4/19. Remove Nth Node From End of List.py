# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
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



