package com.zalizniak.medium.tree.binary.lowest_common_ancestor;

import com.zalizniak.medium.tree.binary.BinaryTreeNode;
import com.zalizniak.medium.tree.binary.BinaryTreePrinter;
import org.junit.Assert;
import org.junit.Test;

public class LowestCommonAncestorTest {

    private LowestCommonAncestor ancestor = new LowestCommonAncestor();

    @Test
    public void test() {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(5);

        BinaryTreeNode root = n2;

        n2.left = n1;
        n2.right = n3;

        n3.left = n4;
        n3.right = n5;

        BinaryTreePrinter.printNode(n2);

        Assert.assertEquals(3, ancestor.getLowestCommonAncestor(root, 4, 5));
        Assert.assertEquals(2, ancestor.getLowestCommonAncestor(root, 4, 1));
        Assert.assertEquals(2, ancestor.getLowestCommonAncestor(root, 1, 3));
        Assert.assertEquals(2, ancestor.getLowestCommonAncestor(root, 3, 1));
    }
}
