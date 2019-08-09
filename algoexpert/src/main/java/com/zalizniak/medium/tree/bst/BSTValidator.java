package com.zalizniak.medium.tree.bst;

import java.util.Stack;

public class BSTValidator {

    public static boolean isValid(BinaryTreeNode rootNode) {

        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(rootNode);

        while (!stack.isEmpty()) {
            BinaryTreeNode itNode = stack.pop();

            if (itNode.left != null) {
                if (itNode.data < itNode.left.data) {
                    return false;
                }
                stack.push(itNode.left);
            }

            if (itNode.right != null) {
                if (itNode.data > itNode.right.data) {
                    return false;
                }
                stack.push(itNode.right);
            }

            System.out.println("Visited: " + itNode);

        }

        return true;
    }
}
