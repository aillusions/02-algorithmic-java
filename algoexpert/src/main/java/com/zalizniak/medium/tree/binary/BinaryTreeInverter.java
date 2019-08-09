package com.zalizniak.medium.tree.binary;

import java.util.Stack;

public class BinaryTreeInverter {

    public static void invertTree(BinaryTreeNode root) {

        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }

            BinaryTreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
    }
}
