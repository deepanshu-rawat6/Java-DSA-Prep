package com.deepanshu.dsa_practice.leetcode.linkedlist;

public class ListNode {
    int val;

    int size;

    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(ListNode next) {
        this.next = next;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    ListNode insertAtHead(ListNode head, int value) {
        head = new ListNode(value,head);
        size++;
        return head;
    }

    ListNode insertAtTail(ListNode head, int value) {
        ListNode curr = head;
        while( curr.next != null) {
            curr = curr.next;
        }

        ListNode listNode = new ListNode(value, null);
        curr.next = listNode;
        curr = listNode;
        size++;
        return head;
    }
    ListNode insertAtNthPos(ListNode head, int value, int pos) {
        if (pos == 0) {
            return insertAtHead(head, value);
        } else if (pos == size) {
            return insertAtTail(head, value);
        } else {
            ListNode temp = head;
            for (int i = 1; i < pos; i++) {
                temp = temp.next;
            }
            temp.next = new ListNode(value,temp.next);
            size++;
            return head;
        }
    }

    ListNode deleteAtHead(ListNode head) {
        if (head == null) {
            System.out.println("\nLinked list is empty");
            return null;
        } else {
            head = head.next;
            size--;
            return head;
        }
    }

    ListNode deleteAtTail(ListNode head) {
        if (head == null) {
            System.out.println("\nLinked list is empty");
            return null;
        } else {
            ListNode temp = head;
            while(temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            size--;
            return head;
        }
    }
    ListNode deleteAtNthPos(ListNode head, int pos) {
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
            size--;
            return head;
        }
    }

    void displayLL(ListNode head) {
        if (head == null) {
            System.out.println("Linked List is empty!");
        } else {
            ListNode temp = head;
            System.out.println("\nLinked List: ");
            while(temp != null) {
                System.out.print(temp.val + " -> ");
                temp = temp.next;
            }
            System.out.print("END");
        }
    }
}
