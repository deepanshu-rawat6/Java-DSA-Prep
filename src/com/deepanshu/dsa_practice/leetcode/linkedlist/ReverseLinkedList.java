package com.deepanshu.dsa_practice.leetcode.linkedlist;

public class ReverseLinkedList {
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

//    https://leetcode.com/problems/palindrome-linked-list/description/
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        ListNode indx = head;
        ListNode indxFromEnd = reverseList(getMid(indx));
        while (indx != null && indxFromEnd != null) {
            if (indx.val != indxFromEnd.val) {
                return false;
            }
            indx = indx.next;
            indxFromEnd = indxFromEnd.next;
        }
        return true;
    }

    public ListNode getMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = null;

        while (fast != null && fast.next != null) {
            slow = (slow == null) ? head : slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;

        return mid;
    }

//    Reverse Nodes in k-Group
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;

        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }

        if (count == k) {
            curr = reverseKGroup(curr, k);

            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = curr;
                curr = head;
                head = temp;
            }

            head = curr;
        }

        return head;
    }
}
