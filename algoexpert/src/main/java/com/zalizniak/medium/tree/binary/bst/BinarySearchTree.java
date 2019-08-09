package com.zalizniak.medium.tree.binary.bst;

import com.zalizniak.medium.tree.binary.BinaryTreeNode;
import com.zalizniak.medium.tree.binary.BinaryTreePrinter;
import com.zalizniak.medium.tree.binary.BinaryTreeTraversal;

public class BinarySearchTree {

    private BinaryTreeNode root;

    /**
     * A new key is always inserted at leaf
     * Leaf node is a node that does not have any further edges connected.
     */
    public BinaryTreeNode insertIterative(Integer val) {

        BinaryTreeNode newNode = new BinaryTreeNode(val);

        if (root == null) {
            root = newNode;
        } else {

            BinaryTreeNode itNode = root;

            while (true) {
                if (itNode.data < newNode.data) {
                    if (itNode.right == null) {
                        System.out.println("Adding: " + val + " to: " + itNode);
                        itNode.right = newNode;
                        break;
                    } else {
                        itNode = itNode.right;
                    }

                } else if (itNode.data > newNode.data) {

                    if (itNode.left == null) {
                        System.out.println("Adding: " + val + " to: " + itNode);
                        itNode.left = newNode;
                        break;
                    } else {
                        itNode = itNode.left;
                    }

                } else {
                    throw new RuntimeException("Duplication: " + val);
                }
            }
        }

        return newNode;
    }

    public int findMin() {
        BinaryTreeNode currNode = root;
        while (true) {
            if (currNode.left == null) {
                return currNode.data;
            } else {
                currNode = currNode.left;
            }
        }
    }

    public int findMax() {
        BinaryTreeNode currNode = root;
        while (true) {
            if (currNode.right == null) {
                return currNode.data;
            } else {
                currNode = currNode.right;
            }
        }
    }

    public void print() {
        BinaryTreePrinter.printNode(root);
    }

    public void printInorder() {
        BinaryTreeTraversal.printInorder(root);
    }

}
