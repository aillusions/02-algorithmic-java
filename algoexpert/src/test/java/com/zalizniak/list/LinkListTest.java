package com.zalizniak.list;

import org.junit.Assert;
import org.junit.Test;

public class LinkListTest {

    @Test
    public void testLinkedListAddGet() {
        LinkList linkList = new LinkList();

        // Part 1

        linkList.add(100);

        Assert.assertEquals(100, (int) linkList.get(0));
        Assert.assertNotNull(linkList.getNode(0));
        Assert.assertNull(linkList.getNode(1));

        // Part 2

        linkList.add(200);
        linkList.add(300);

        Assert.assertEquals(100, (int) linkList.get(0));
        Assert.assertEquals(200, (int) linkList.get(1));
        Assert.assertEquals(300, (int) linkList.get(2));
    }

    @Test
    public void testLinkedListAddGetInBetween() {
        LinkList linkList = new LinkList();

        linkList.add(100, 0);
        linkList.add(200, 1);
        linkList.add(150, 1);

        Assert.assertEquals(100, (int) linkList.get(0));
        Assert.assertEquals(150, (int) linkList.get(1));
        Assert.assertEquals(200, (int) linkList.get(2));
    }


    @Test
    public void testLinkedListRemove() {
        LinkList linkList = new LinkList();

        linkList.add(100);
        linkList.add(200);
        linkList.add(300);

        Assert.assertEquals(3, linkList.size());
        Assert.assertNotNull(linkList.getNode(0));

        linkList.remove(0);
        linkList.remove(0);
        linkList.remove(0);

        Assert.assertEquals(0, linkList.size());
        Assert.assertNull(linkList.getNode(0));
    }
}
