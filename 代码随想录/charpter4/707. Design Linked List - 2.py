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
        self.size = 0
        self.head = Node(0)  # pseudo-head

    def get(self, index: int) -> int:
        if index >= self.size:
            return -1

        cur = self.head
        for i in range(0, index + 1):
            cur = cur.next
        return cur.val

    def addAtHead(self, val: int) -> None:
        self.addAtIndex(0, val)

    def addAtTail(self, val: int) -> None:
        self.addAtIndex(self.size, val)

    def addAtIndex(self, index: int, val: int) -> None:
        if index > self.size:
            return

        self.size += 1
        pre = self.head
        for i in range(index):
            pre = pre.next

        pre.next = Node(val, pre.next)

    def deleteAtIndex(self, index: int) -> None:
        if index >= self.size:
            return

        self.size -= 1
        pre = self.head
        for i in range(index):
            pre = pre.next

        pre.next = pre.next.next


if __name__ == '__main__':
    myLinkedList = MyLinkedList()
    print(myLinkedList.addAtIndex(1, 0))
    print(myLinkedList.get(0))
