package com.zalizniak.medium.tree.binary;

import org.junit.Test;

public class BinaryTreeTest {

    @Test
    public void testBST() {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.insertIterative(9);
        binaryTree.insertIterative(7);
        binaryTree.insertIterative(23);
        binaryTree.insertIterative(0);
        binaryTree.insertIterative(12);
        binaryTree.insertIterative(49);
        binaryTree.insertIterative(8);
        binaryTree.insertIterative(11);
        binaryTree.insertIterative(6);

        binaryTree.print();
    }
}
