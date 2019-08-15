package com.zalizniak.hard.red_black_tree;

import com.zalizniak.medium.tree.binary.BinaryTreePrinter;

public class RedBlackTree {

    RedBlackNode root;


    public void add(int value) {

        RedBlackNode newNode = new RedBlackNode(value);

        if (root == null) {
            root = newNode;
        } else {
            RedBlackNode itNode = root;

            while (true) {
                if (value < itNode.data) {
                    if (itNode.left == null) {
                        itNode.left = newNode;
                        break;
                    } else {
                        itNode = (RedBlackNode) itNode.left;
                    }
                } else if (value > itNode.data) {
                    if (itNode.right == null) {
                        itNode.right = newNode;
                        break;
                    } else {
                        itNode = (RedBlackNode) itNode.right;
                    }
                } else {
                    throw new RuntimeException("Duplicated value: " + value);
                }
            }
        }
    }

    public void print() {
        BinaryTreePrinter.printNode(root);
    }
}
