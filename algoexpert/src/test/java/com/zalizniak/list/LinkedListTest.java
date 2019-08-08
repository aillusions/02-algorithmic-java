package com.zalizniak.list;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {

    @Test
    public void testLinkedListAddGet() {
        LinkedList linkedList = new LinkedList();

        linkedList.add(100);
        // linkedList.add(200);
        // linkedList.add(300);

        Assert.assertEquals(100, (int) linkedList.get(0));
        Assert.assertNotNull(linkedList.getNode(0));
        Assert.assertNull(linkedList.getNode(1));

        // Assert.assertEquals(200, (int) linkedList.get(1));
        // Assert.assertEquals(300, (int) linkedList.get(2));
    }
}
