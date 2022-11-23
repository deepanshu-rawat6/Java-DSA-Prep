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
    public void insertFirst (int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

//    this operation takes constant time complexity, because we are maintaining the tail
    public void insertLast (int val) {
        if (tail == null) {
            insertFirst(val);
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

//    this operation takes linear time
    public void insert(int val,int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
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

//    this operation takes O(1) operation
    public int deleteFirst() {
        int val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size -= 1;
        return val;
    }

//    this operation takes linear time complexity
    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }

        Node secondlast = get(size - 2);
        int val = tail.value;
        tail = secondlast;
        tail.next = null;
        return val;
    }

//    linear time complexity
    public int delete(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }

        Node prev = get(index - 1);
        int val =  prev.next.value;
        prev.next = prev.next.next;
        return val;
    }

    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
//    this operation is used to take the required Node
    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
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