package com.deepanshu.dsa_practice.leetcode.linkedlist;

import java.util.List;

public class MoreOnLinkedLists {

//    Reorder the list (https://leetcode.com/problems/reorder-list/)
    public ListNode getMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = null;

        while (fast != null && fast.next != null) {
            slow = (slow == null) ? head : slow.next;
            fast = fast.next.next;
        }

        assert slow != null;
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }

    public ListNode reverseList(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        ListNode next_node = head.next;
        head.next = newHead;
        return reverseList(next_node, head);
    }

    public void printLL(ListNode head) {
        if (head == null) {
            System.out.println("\nList is empty");
        } else {
            ListNode temp = head;
            System.out.println("\nLinked List: ");
            while (temp != null) {
                System.out.print(temp.val + " -> ");
                temp = temp.next;
            }
            System.out.println(" END");
        }
    }

    public ListNode mergeLL(ListNode l1, ListNode l2, boolean fromL1) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (fromL1) {
            l1.next = mergeLL(l1.next, l2, false);
            return l1;
        } else {
            l2.next = mergeLL(l1, l2.next, true);
            return l2;
        }
    }
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            printLL(head);
            return;
        }
        ListNode mid = getMiddle(head);
        ListNode headFromEnd = reverseList(mid,null);
        printLL(head);
        printLL(headFromEnd);
        head = mergeLL(head, headFromEnd, true);
        printLL(head);
    }

//    Delete Duplicates from the list
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = head;

        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }



//    Merge Sort on Linked List
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = middleNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return mergeTwoLists(left, right);
    }

//    Get the middle node and then make the next node to the mid as null to avoid any stackoverflow error(breaking links)
    ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        assert midPrev != null;
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

//    Return the middle node of a linked list then make the next node to the mid as null to avoid any stackoverflow error(breaking links)
    public ListNode middleNode(ListNode head) {
        ListNode slow = null;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = (slow == null) ? head : slow.next;
            fast = fast.next.next;
        }
        assert slow != null;
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }

//    Merge two sorted lists
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }


//    Bubble Sort

//    Odd Even Linked List
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode head2 = head.next;
        ListNode temp1 = head;
        ListNode temp2 = head2;

        while (temp1 != null && temp1.next != null && temp2 != null && temp2.next != null) {
            temp1.next = temp1.next.next;
            temp2.next = temp2.next.next;
            temp2 = temp2.next;
            temp1 = temp1.next;
        }

        if  (temp1.next != null) {
            temp1.next = null;
        }

        if (temp2.next != null) {
            temp2.next = null;
        }

        printLL(head);
        printLL(head2);

        temp1 = head;
        while (temp1.next != null) {
            temp1 = temp1.next;
        }

        temp1.next = head2;

        return head;
    }
}
