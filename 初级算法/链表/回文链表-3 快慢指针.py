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
l = [1, 2, 4, 2, 1]
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
        if head is None or head.next is None:
            return True
        pre_head = ListNode(-1)  # 哑节点
        pre_head.next = head

        # 通过快慢指针来找到中间值, 需要记录下中间节点
        # 如果是奇数个，则中间的节点作为前半部分
        slow_p = pre_head  # 慢指针
        quick_p = pre_head  # 快指针
        counter = 0  # 计数器
        while quick_p is not None:
            slow_p = slow_p.next
            quick_p = quick_p.next
            counter += 1
            if quick_p is None:
                break
            else:
                quick_p = quick_p.next
                counter += 1
        counter -= 1  # quick 最后一个节点不算
        if counter % 2 == 1:
            # 如果奇数，slow 再前进一位
            slow = slow_p.next

        # 反转后半部分
        middle_p = slow_p
        middle_p = self.reverse_node(middle_p)

        # 比较
        p1 = head  # 前半部分
        p2 = middle_p  # 后半部分
        res = True
        while p2 is not None:
            if p1.val != p2.val:
                res = False
                break
            p1 = p1.next
            p2 = p2.next

        # 恢复后半部分
        middle_p = self.reverse_node(middle_p)

        # 返回结果
        return res

    def reverse_node(self, head):
        if head is None or head.next is None:
            return head
        else:
            end_node = self.reverse_node(head.next)  # 获取并返回最后的节点

            # 交换当前节点和子节点
            head.next.next = head
            head.next = None

            return end_node


if __name__ == '__main__':
    print_link_list(head)
    print(Solution().isPalindrome(head))
    print_link_list(head)
