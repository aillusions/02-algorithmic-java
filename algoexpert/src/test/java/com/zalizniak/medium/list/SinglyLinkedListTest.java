package com.zalizniak.medium.list;

import org.junit.Assert;
import org.junit.Test;

public class SinglyLinkedListTest {

    @Test
    public void testConstruct() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        list.print();
    }

    @Test
    public void testGetNthFromTheEnd() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        Assert.assertEquals(40, list.getNthFromTheEnd(2));
    }
}
