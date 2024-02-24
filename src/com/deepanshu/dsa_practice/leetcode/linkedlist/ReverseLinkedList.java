package com.deepanshu.dsa_practice.leetcode.linkedlist;

public class ReverseLinkedList {

    public ListNode revIterative(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
        return newHead;
    }
    public ListNode revRecursive(ListNode head, ListNode newHead) {
        if (head == null) return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return revRecursive(next, head);
    }
    public ListNode reverseList(ListNode head) {
        return revRecursive(head, null);
//        return revIterative(head);
    }
}
