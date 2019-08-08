package com.zalizniak.tree;

import com.zalizniak.tree.BinarySearchTree;
import junit.framework.TestCase;

public class BinarySearchTreeTest extends TestCase {

    public void testBinaryTree() {

        BinarySearchTree.BinarySearchTreeNode A = new BinarySearchTree.BinarySearchTreeNode("A");

        BinarySearchTree tree = new BinarySearchTree(A);
        A.leftNode = new BinarySearchTree.BinarySearchTreeNode("B");
        A.rightNode = new BinarySearchTree.BinarySearchTreeNode("C");
    }
}
