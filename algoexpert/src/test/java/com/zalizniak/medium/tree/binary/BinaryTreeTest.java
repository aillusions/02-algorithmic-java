package com.zalizniak.medium.tree.binary;

import org.junit.Test;

public class BinaryTreeTest {

    @Test
    public void testBST() {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.insertIterative(9);
        binaryTree.insertIterative(8);
        binaryTree.insertIterative(23);
        binaryTree.insertIterative(-3);
        binaryTree.insertIterative(12);
        binaryTree.insertIterative(49);

        binaryTree.print();
    }
}
