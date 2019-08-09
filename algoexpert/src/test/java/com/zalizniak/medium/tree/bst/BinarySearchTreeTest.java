package com.zalizniak.medium.tree.bst;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTreeTest {

    @Test
    public void testBST() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        BinaryTreeNode n_9 = binarySearchTree.insertIterative(9);
        BinaryTreeNode n_8 = binarySearchTree.insertIterative(8);
        BinaryTreeNode n_23 = binarySearchTree.insertIterative(23);
        BinaryTreeNode n_0 = binarySearchTree.insertIterative(0);
        BinaryTreeNode n_12 = binarySearchTree.insertIterative(12);
        BinaryTreeNode n_49 = binarySearchTree.insertIterative(49);
        BinaryTreeNode n_2 = binarySearchTree.insertIterative(2);
        BinaryTreeNode n_200 = binarySearchTree.insertIterative(200);

        binarySearchTree.print();

        binarySearchTree.printInorder();

        Assert.assertEquals(n_0, n_8.left);
        Assert.assertNull(n_8.right);

        Assert.assertEquals(n_12, n_23.left);
        Assert.assertEquals(n_49, n_23.right);

        Assert.assertNull(n_0.left);
        Assert.assertEquals(n_2, n_0.right);

        Assert.assertEquals(0, binarySearchTree.findMin());
        Assert.assertEquals(200, binarySearchTree.findMax());
    }
}
