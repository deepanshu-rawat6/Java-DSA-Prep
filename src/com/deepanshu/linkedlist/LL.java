package com.deepanshu.linkedlist;

public class LL {

    private Node head;
    private Node tail;

    private int size;

    public LL() {
        this.size = 0;
    }
    private class Node {
        private int val;
        private Node next;

        public Node(int value){
            this.val = value;
        }

        public Node(int value, Node next) {
            this.val = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {

    }
}
