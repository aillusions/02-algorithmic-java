package com.zalizniak.hard.red_black_tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RedBlackTreeTest {

    @Test
    public void testAddRemove() {
        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.add(5);
        Assert.assertEquals(Arrays.asList(5), redBlackTree.inOrder());

        redBlackTree.add(7);
        redBlackTree.add(3);
        Assert.assertEquals(Arrays.asList(3, 5, 7), redBlackTree.inOrder());

        redBlackTree.add(4);
        redBlackTree.add(2);

        Assert.assertEquals(Arrays.asList(2, 3, 4, 5, 7), redBlackTree.inOrder());

        redBlackTree.add(9);

        redBlackTree.print();
        Assert.assertEquals(Arrays.asList(2, 3, 4, 5, 7, 9), redBlackTree.inOrder());

        redBlackTree.delete(4);
        redBlackTree.print();
        Assert.assertEquals(Arrays.asList(2, 3, 5, 7, 9), redBlackTree.inOrder());

        redBlackTree.delete(3);
        redBlackTree.print();
        Assert.assertEquals(Arrays.asList(2, 5, 7, 9), redBlackTree.inOrder());

        redBlackTree.delete(7);
        redBlackTree.print();
        Assert.assertEquals(Arrays.asList(2, 5, 9), redBlackTree.inOrder());

        redBlackTree.add(7);
        redBlackTree.add(8);
        redBlackTree.print();
        Assert.assertEquals(Arrays.asList(2, 5, 7, 8, 9), redBlackTree.inOrder());

        redBlackTree.delete(5);
        redBlackTree.print();
        Assert.assertEquals(Arrays.asList(2, 7, 9, 8), redBlackTree.inOrder());
    }

    //@Test
    //public void testUnbalanced() {
    //    RedBlackTree tree = new RedBlackTree();
//
    //    for (int i = 0; i <= 5; i++) {
    //        tree.add(i);
    //    }
//
    //    tree.print();
    //}
}
