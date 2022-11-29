package com.deepanshu.linkedlist;

public class CycleQuestions {
    private ListNode head;
    private ListNode tail;
    private int size;
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int x) {
            val = x;
            next = null;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //    cycle detection using fast and slow pointers
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }


    //    finding the length of the cycle
//    https://leetcode.com/problems/linked-list-cycle/description/
//    Amazon and Microsoft
    public int lenCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                int len = 0;
                do {
                    len++;
                    slow = slow.next;
                } while (slow != fast);
                return len;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

    }
}
