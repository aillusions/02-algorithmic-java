package com.zalizniak.medium.list;

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
}
