package com.zalizniak.hard.red_black_tree;

import com.zalizniak.medium.tree.binary.BinaryTreePrinter;

public class RedBlackTree {

    RedBlackNode root;

    public void add(int value) {

        RedBlackNode newNode = new RedBlackNode(value);

        if (root == null) {
            root = newNode;
            newNode.setBlack();
            newNode.parent = null;
        } else {

            newNode.setRed(); // why ??

            RedBlackNode temp = root;

            while (true) {
                if (value < temp.data) {
                    if (temp.left == null) {
                        temp.left = newNode;
                        newNode.parent = temp;
                        break;
                    } else {
                        temp = (RedBlackNode) temp.left;
                    }
                } else if (value > temp.data) {
                    if (temp.right == null) {
                        temp.right = newNode;
                        newNode.parent = temp;
                        break;
                    } else {
                        temp = (RedBlackNode) temp.right;
                    }
                } else {
                    throw new RuntimeException("Duplicated value: " + value);
                }
            }

            fixTree(newNode);
        }
    }

    public void delete(int value) {
        RedBlackNode nodeToRemove = getNode(value);

        if (nodeToRemove == null) {
            throw new RuntimeException("Unable to remove missing value: " + value);
        } else {
            RedBlackNode parent = nodeToRemove.parent;
            if (nodeToRemove.left == null && nodeToRemove.right == null) { // If n has no children, we only have to remove n from the tree.
                if (parent.right != null && parent.right.data.equals(nodeToRemove.data)) {
                    parent.right = null;
                } else {
                    parent.left = null;
                }
            } else if (nodeToRemove.left == null || nodeToRemove.right == null) { // If n has a single child, we remove n and connect its parent to its child.
                RedBlackNode singleChild = (RedBlackNode) (nodeToRemove.left == null ? nodeToRemove.right : nodeToRemove.left);
                if (parent.right != null && parent.right.data.equals(nodeToRemove.data)) {
                    parent.right = singleChild;
                } else {
                    parent.left = singleChild;
                }
            }
        }
    }

    public RedBlackNode getNode(int value) {

        RedBlackNode node = root;
        while (node != null && node.data != value) {
            if (node.data > value) {
                node = (RedBlackNode) node.left;
            } else {
                node = (RedBlackNode) node.right;
            }
        }

        return node;
    }

    protected void fixTree(RedBlackNode newNode) {

    }

    public void print() {
        BinaryTreePrinter.printNode(root);
    }
}
