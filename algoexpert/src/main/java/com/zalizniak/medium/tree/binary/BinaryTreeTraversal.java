package com.zalizniak.medium.tree.binary;

public class BinaryTreeTraversal {

    public static void printInorder(BinaryTreeNode node) {
        if (node == null)
            return;

        printInorder(node.left);

        System.out.print(node.toString() + " ");

        printInorder(node.right);
    }

}
