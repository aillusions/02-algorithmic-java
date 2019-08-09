package com.zalizniak.medium.tree.bst;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeTest {

    @Test
    public void testBST() {
        BinaryTree binaryTree = new BinaryTree();

        BinaryTreeNode n_9 = binaryTree.insertIterative(9);
        BinaryTreeNode n_8 = binaryTree.insertIterative(8);
        BinaryTreeNode n_23 = binaryTree.insertIterative(23);
        BinaryTreeNode n_0 = binaryTree.insertIterative(0);
        BinaryTreeNode n_12 = binaryTree.insertIterative(12);
        BinaryTreeNode n_49 = binaryTree.insertIterative(49);
        BinaryTreeNode n_2 = binaryTree.insertIterative(2);
        BinaryTreeNode n_200 = binaryTree.insertIterative(200);

        binaryTree.print();

        Assert.assertEquals(n_0, n_8.left);
        Assert.assertNull(n_8.right);

        Assert.assertEquals(n_12, n_23.left);
        Assert.assertEquals(n_49, n_23.right);

        Assert.assertNull(n_0.left);
        Assert.assertEquals(n_2, n_0.right);
    }
}
