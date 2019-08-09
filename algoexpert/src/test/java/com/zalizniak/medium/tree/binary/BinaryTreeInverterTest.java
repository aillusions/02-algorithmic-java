package com.zalizniak.medium.tree.binary;

import org.junit.Test;

public class BinaryTreeInverterTest {

    @Test
    public void shouldInvertBinaryTree() {

        BinaryTreeNode n0 = new BinaryTreeNode(0);
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(5);

        n1.left = n0;

        n2.left = n1;
        n2.right = n3;

        n3.left = n4;
        n3.right = n5;

        BinaryTreePrinter.printNode(n2);
        BinaryTreeTraversal.printInorder(n2);
        System.out.println();

        BinaryTreeInverter.invertTree(n2);

        BinaryTreePrinter.printNode(n2);
        BinaryTreeTraversal.printInorder(n2);
        System.out.println();
    }
}
