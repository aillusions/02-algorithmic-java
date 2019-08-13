package com.zalizniak.medium.list;

import org.junit.Assert;
import org.junit.Test;

public class SinglyLinkedListTest {

    SinglyLinkedList small_list = new SinglyLinkedList();

    {
        small_list.add(10);
        small_list.add(20);
        small_list.add(30);
        small_list.add(40);
        small_list.add(50);
    }

    SinglyLinkedList large_list = new SinglyLinkedList();

    {
        for (int i = 0; i < 10_000; i++) {
            large_list.add(i);
        }
    }

    @Test
    public void testConstruct() {
        small_list.print();
    }

    @Test
    public void testGetNth() {
        Assert.assertEquals(10, small_list.getNth(1));
        Assert.assertEquals(30, small_list.getNth(3));
        Assert.assertEquals(50, small_list.getNth(5));
    }

    @Test
    public void testGetNthLarge() {
        Assert.assertEquals(9000, large_list.getNth(9_001));
        Assert.assertEquals(9100, large_list.getNth(9_101));
        Assert.assertEquals(9200, large_list.getNth(9_201));
    }

    @Test
    public void testGetNthFromTheEnd() {
        Assert.assertEquals(40, small_list.getNthFromTheEnd(2));
        Assert.assertEquals(10, small_list.getNthFromTheEnd(5));
        Assert.assertEquals(50, small_list.getNthFromTheEnd(1));
    }

    @Test
    public void testGetNthFromTheEndLarge() {
        Assert.assertEquals(9000, large_list.getNthFromTheEnd(1000));
    }
}
