package com.zalizniak.medium.tree.binary;

import org.junit.Test;

public class BinaryTreeTest {

    @Test
    public void testBST() {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.add(9);
        binaryTree.add(8);
        binaryTree.add(23);
        binaryTree.add(0);
        binaryTree.add(12);
        binaryTree.add(49);

        binaryTree.print();
    }
}
