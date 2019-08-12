package com.zalizniak.medium.list;

public class SinglyLinkedList {

    private ListNode root;

    public void add(int data) {
        ListNode newNode = new ListNode(data);

        if (root == null) {
            root = newNode;
        } else {
            ListNode currentNode = root;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    public int getNthFromTheEnd(int nth) {
        return 0;
    }

    public void print() {

        ListNode currentNode = root;

        System.out.print("[");
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.print("]");
    }
}
