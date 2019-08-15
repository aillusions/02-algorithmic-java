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

    protected void fixTree(RedBlackNode newNode) {

    }

    public void print() {
        BinaryTreePrinter.printNode(root);
    }
}
