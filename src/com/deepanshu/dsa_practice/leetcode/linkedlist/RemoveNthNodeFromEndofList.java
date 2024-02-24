package com.deepanshu.dsa_practice.leetcode.linkedlist;

public class RemoveNthNodeFromEndofList {
    public int sizeOfLinkedList(ListNode head) {
        if (head == null) {
            return -1;
        } else {
            int size = 0;
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
                size++;
            }
            return size;
        }
    }

    public ListNode deleteAtHead(ListNode head) {
        if (head == null) {
            return null;
        } else {
            head = head.next;
            return head;
        }
    }

    public ListNode deleteAtTail(ListNode head) {
        if (head == null) {
            return null;
        } else {
            ListNode temp = head;
            while(temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            return head;
        }
    }

    public ListNode deleteAtNthNode(ListNode head, int pos, int size) {
        if (pos == 0) {
            return deleteAtHead(head);
        } else if (pos == size) {
            return deleteAtTail(head);
        } else {
            ListNode temp = head;
            for (int i = 1; i < pos; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            return head;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = sizeOfLinkedList(head);
        return deleteAtNthNode(head, size - n + 1, size);
    }
}
