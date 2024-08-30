package com.deepanshu.dsa_practice.leetcode.linkedlist;

public class CycleProblemsInLinkedList {

    public void addCycle(ListNode head, int pos) {
        if (head == null) {
            System.out.println("\nLinked List is empty!");
        } else {
            ListNode lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            ListNode cycleEndPoint = head;
            for (int i = 1; i < pos; i++) {
                assert cycleEndPoint != null;
                cycleEndPoint = cycleEndPoint.next;
            }
            lastNode.next = cycleEndPoint;
        }
        return;
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

    public ListNode detectCycle(ListNode head) {
        ListNode fastPointer = head;
        ListNode slowPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if (slowPointer == fastPointer) {
                slowPointer = head;

                while (slowPointer != fastPointer) {
                    slowPointer = slowPointer.next;
                    fastPointer = fastPointer.next;
                }
                return slowPointer;
            }
        }

        return null;
    }

    public int lengthCycle(ListNode head) {
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        boolean hasCycle = false;

        while(fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;

            if (slowPointer == fastPointer) {
                hasCycle = true;
                break;
            }
        }

        if(hasCycle) {
            ListNode temp = slowPointer;
            int length = 0;
            do {
                temp = temp.next;
                length++;
            } while (temp != fastPointer);
            return length;
        } else {
            return 0;
        }
    }

//    Happy Number
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private int findSquare(int number) {
        int ans = 0;
        while (number > 0) {
            int rem = number % 10;
            ans += rem * rem;
            number /= 10;
        }
        return ans;
    }

    public ListNode deleteMiddle(ListNode head) {
//        Getting at node before the middle node to move next 2 times to delete the node
        ListNode prevMid = getMidPrev(head);
//        if the prevMid node is null, then it means we need to delete the head node of the list(length of list is 1)
        if (prevMid == null) {
            return deleteAtHead(head);
        }
//        Otherwise we simply move next 2 times to delete the middle node
        prevMid.next = prevMid.next.next;
        return head;
    }


//  To get a node before the middle node
    public ListNode getMidPrev(ListNode head) {
        ListNode slow = null;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = (slow == null) ? head : slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode deleteAtHead(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        } else {
            head = head.next;
            return head;
        }
    }
}
