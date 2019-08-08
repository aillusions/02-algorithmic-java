package com.zalizniak.list;

public class LinkList {

    private LinkedNode head;

    private int size = 0;

    public int size() {
        return size;
    }

    public Integer get(int position) {
        assertPosition(position);
        return getNode(position).value;
    }

    public LinkedNode getNode(int position) {

        assertPosition(position);

        LinkedNode itItem = head;
        int itIdx = -1;

        while (itIdx != position - 1) {
            itItem = itItem.next;
            itIdx++;
        }

        return itItem;
    }

    public void add(Integer value) {
        add(value, size);
    }

    public void add(Integer value, int position) {

        assertPosition(position);

        LinkedNode newItem = new LinkedNode(value);

        if (head == null) {
            head = newItem;
            size += 1;
        } else {
            LinkedNode prevNode = getNode(position - 1);
            if (prevNode.next != null) {
                newItem.next = prevNode.next;
            }

            prevNode.next = newItem;
            size += 1;
        }
    }

    public void remove(int position) {
        assertPosition(position);

        if (position == 0) {
            LinkedNode nodeToRemove = getNode(position);
            head = nodeToRemove.next;
        } else {
            LinkedNode prevNode = getNode(position - 1);
            LinkedNode nodeToRemove = prevNode.next;
            prevNode.next = nodeToRemove.next;
        }

        size -= 1;
    }

    private void assertPosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("!(position < 0)");
        }

        if (position > size) {
            throw new IllegalArgumentException("!(position > size)");
        }

    }

}
