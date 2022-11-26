package com.deepanshu.linkedlist;

public class CLL {
    private Node head;
    private Node tail;

    public CLL() {
        this.head = null;
        this.tail = null;
    }

    public void insert(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void display() {
        if (head == null) {
            System.out.println("The list is empty!");
        } else {
            Node node = head;
            do {
                System.out.print(node.val + " --> ");
                node = node.next;
            } while (node != head);
            System.out.print(" HEAD \n");
        }
    }

    public void delete(int val) {
        Node node = head;
        if (node == null) {
            return;
        }

        if (node.val == val) {
            head = head.next;
            tail.next = head.next;
            return;
        }
        do{
            Node n = node.next;
            if (n.val == val) {
                node.next = n.next;
                break;
            }
            node = node.next;
        } while(node != head);

    }
    private class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

    }
}
