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

    def __str__(self):
        return "%s -> %s" % (self.val, self.next)


# 输出链表
def print_link_list(head):
    node = head
    print("[", end="")
    while node != None:
        print(node.val, "->", end="", sep="")
        node = node.next
    print("None]")


# 创建链表
l = [4, 5, 1, 9]
l = [1, 2, 2, 1]
head = ListNode(l[0])
node = head
for i in l[1:]:
    node.next = ListNode(i)
    node = node.next


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        """借助全局变量向后遍历，借助栈向后遍历"""
        self.front_p = head
        return self.review_visit(head)

    def review_visit(self, head):
        """最后节点返回 True，作为开端"""
        if head is None:
            return True
        else:
            if self.review_visit(head.next) == False:
                # 如果以前都是错误的，直接返回
                return False
            elif head.val != self.front_p.val:
                # 检查是否对称
                return False
            self.front_p = self.front_p.next  # 更新
            return True  # 默认返回True



if __name__ == '__main__':
    print_link_list(head)
    print(Solution().isPalindrome(head))
    print_link_list(head)
