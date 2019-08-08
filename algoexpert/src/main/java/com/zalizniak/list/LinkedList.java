package com.zalizniak.list;

public class LinkedList {

    private LinkedNode head;

    private int size = 0;

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
            return;
        }

        getNode(position - 1).next = newItem;
        size += 1;
    }

    public void remove(int position) {

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
