package com.zalizniak.tree.binary;

import junit.framework.TestCase;

public class BinaryTreePrinterTest extends TestCase {

    public void testBinaryTree() {

        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(5);

        n2.left = n1;
        n2.right = n3;

        n3.left = n4;
        n3.right = n5;

        BinaryTreePrinter.printNode(n2);
    }
}
