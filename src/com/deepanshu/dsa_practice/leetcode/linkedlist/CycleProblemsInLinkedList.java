package com.deepanshu.dsa_practice.leetcode.linkedlist;

public class CycleProblemsInLinkedList {

    public void addCycle(ListNode head, int pos) {
        if (head == null) {
            System.out.println("\nLinked List is empty!");
            return;
        } else {
            ListNode lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            ListNode cycleEndPoint = head;
            for (int i = 1; i < pos; i++) {
                cycleEndPoint = cycleEndPoint.next;
            }
            lastNode.next = cycleEndPoint;
            return;
        }
    }
    public boolean hasCycle(ListNode head) {
        ListNode fastPointer = head;
        ListNode slowPointer = head;

        while(fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if (slowPointer == fastPointer) {
                return true;
            }
        }

        return false;
    }
}
