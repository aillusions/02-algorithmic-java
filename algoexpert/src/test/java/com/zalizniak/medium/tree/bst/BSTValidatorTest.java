package com.zalizniak.medium.tree.bst;

import org.junit.Assert;
import org.junit.Test;

public class BSTValidatorTest {

    @Test
    public void shouldValidateValidBst() {

        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(4);

        BinaryTreeNode root = n2;

        n2.left = n1;
        n2.right = n3;

        n3.right = n4;

        BinaryTreePrinter.printNode(root);

        Assert.assertTrue(BSTValidator.isValid(root));
    }

    @Test
    public void shouldValidateInvalidBst() {

        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(4);

        BinaryTreeNode root = n2;

        n2.left = n1;
        n2.right = n3;

        n3.left = n4;

        BinaryTreePrinter.printNode(root);

        Assert.assertFalse(BSTValidator.isValid(root));
    }
}
