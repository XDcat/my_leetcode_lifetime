# -*- coding:utf-8 -*-
'''
__author__ = 'XD'
__mtime__ = 2022/9/15
__project__ = my_leetcode_lifetime
Fix the Problem, Not the Blame.
'''


class Node:
    def __init__(self, value=None, nxt=None):
        self.val = value
        self.next = nxt


class MyLinkedList:

    def __init__(self):
        self.head = None

    def get(self, index: int) -> int:
        head = Node(None, self.head)
        pre = head
        cur = head.next
        idx = 0
        while idx < index and cur is not None:
            pre = cur
            cur = cur.next
            idx += 1
        if cur is None:
            return -1
        else:
            return cur.val

    def addAtHead(self, val: int) -> None:
        new_head = Node(val, self.head)
        self.head = new_head

    def addAtTail(self, val: int) -> None:
        head = Node(None, self.head)
        pre = head
        cur = head.next
        while cur is not None:
            pre = cur
            cur = cur.next
        pre.next = Node(val)
        self.head = head.next

    def addAtIndex(self, index: int, val: int) -> None:
        head = Node(None, self.head)
        pre = head
        cur = head.next
        idx = 0
        while idx < index and pre.next is not None:
            pre = cur
            cur = cur.next
            idx += 1
        if pre.next is not None:
            pre.next = Node(val, cur)
        self.head = head.next

    def deleteAtIndex(self, index: int) -> None:
        head = Node(None, self.head)
        pre = head
        cur = head.next
        idx = 0
        while idx < index and cur is not None:
            pre = cur
            cur = cur.next
            idx += 1
        if cur is not None:
            pre.next = cur.next
        self.head = head.next


if __name__ == '__main__':
    myLinkedList = MyLinkedList()
    print(myLinkedList.addAtIndex(1, 0))
    print(myLinkedList.get(0))
