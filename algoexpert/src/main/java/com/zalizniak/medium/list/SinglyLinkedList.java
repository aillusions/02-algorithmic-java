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

    public int getNth(int nth) {
        int idxToFind = nth - 1;
        int idx = 0;
        ListNode node = root;
        while (idx < idxToFind) {
            node = node.next;
            idx++;
        }

        return node.data;
    }

    public int getNthFromTheEnd(int nth) {

        ListNode node = root;
        int maxIdx = 0;
        while (node.next != null) {
            node = node.next;
            maxIdx++;
        }

        node = root;
        int index = 0;
        while (index + (nth - 1) < maxIdx) {
            node = node.next;
            index++;
        }

        return node.data;
    }

    public int getNthFromTheEndFast(int nth) {

        ListNode tail = root;
        ListNode head = root;

        int tailIdx = 0;
        int headIdx = 0;

        while (head.next != null) {
            head = head.next;
            headIdx++;

            if (headIdx - tailIdx == nth) {
                tail = tail.next;
                tailIdx++;
            }
        }

        return tail.data;
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
