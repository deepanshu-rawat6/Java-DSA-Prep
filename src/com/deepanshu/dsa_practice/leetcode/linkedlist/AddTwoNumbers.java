package com.deepanshu.dsa_practice.leetcode.linkedlist;

public class AddTwoNumbers {

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

    public ListNode additionOfNumbers(ListNode l1, ListNode l2, int carry) {
        if (l2 == null) {
            if (carry == 0) {
                return l1;
            } else {
                if (l1 == null) {
                    l1  = new ListNode(carry, null);
                    return l1;
                } else {
                    int temp = (l1.val + carry);
                    l1.val = temp % 10;
                    carry = temp / 10;
                    System.out.println("\nTemp: " + temp + " Carry: " + carry + " L1.val: " + l1.val);
                    l1.next = additionOfNumbers(l1.next, null, carry);
                }
            }
        } else {
            int temp = (l1.val + l2.val + carry);
            l1.val = temp % 10;
            carry = temp / 10;
            System.out.println("\nTemp: " + temp + " Carry: " + carry + " L1.val: " + l1.val);
            l1.next = additionOfNumbers(l1.next, l2.next, carry);
        }
        return l1;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int size_l1 = sizeOfLinkedList(l1);
        int size_l2 = sizeOfLinkedList(l2);

        if (size_l1 > size_l2) {
            return additionOfNumbers(l1, l2, 0);
        } else {
            return additionOfNumbers(l2, l1, 0);
        }
    }
}
