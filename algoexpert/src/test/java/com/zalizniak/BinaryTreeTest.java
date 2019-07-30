package com.zalizniak;

import junit.framework.TestCase;

public class BinaryTreeTest extends TestCase {

    public void testBinaryTree() {

        BinaryTree.BinaryTreeNode A = new BinaryTree.BinaryTreeNode("A");

        BinaryTree tree = new BinaryTree(A);
        A.leftNode = new BinaryTree.BinaryTreeNode("B");
        A.rightNode = new BinaryTree.BinaryTreeNode("C");
    }
}
