package com.deepanshu.linkedlist;

public class LL {
//    benefits of using an extra "tail" variable, some operations which require traversal at end of the list, can takes
//    const time complexity instead of linear time complexity
    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

//    This operation takes O(1) time complexity
    public void insert_at_First (int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    public void insert_at_Last (int val) {
        if (tail == null) {
            insert_at_First(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size += 1;

//        If we are not maintaining the tail, then we have to traverse to the last node:
        /*
        public void insert_at_Last (int val) {
            Node temp = head;
            if (head == null) {
                insert_at_First(val);
                return;
            }
            while (temp != null ) {
                temp = temp.next;
            }
            Node node = new Node(val);
            temp.next = node;
            temp = node;
            size += 1;
         }
         */
    }

    public void insert(int val,int index) {
        if (index == 0) {
            insert_at_First(val);
            return;
        }
        if (index == size) {
            insert_at_Last(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);

        temp.next = node;
        size += 1;
    }

//    This operation takes O(n) time complexity
    public void display() {
        Node temp = head;
        if (head == null) {
            System.out.println("The list is empty!");
        } else {
            while (temp != null) {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }
            System.out.println("END");
        }
    }

//    Node class with data fields: value, Node next and size
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

}