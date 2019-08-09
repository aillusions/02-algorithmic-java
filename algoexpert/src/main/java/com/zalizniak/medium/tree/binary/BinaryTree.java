package com.zalizniak.medium.tree.binary;

public class BinaryTree {

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

            while (itNode.right != null && itNode.left != null) { // go to leaf node

                //System.out.println("Adding: " + val + " visiting: " + itNode);

                if (itNode.data < newNode.data) {
                    itNode = itNode.right;
                } else if (itNode.data > newNode.data) {
                    itNode = itNode.left;
                } else {
                    throw new RuntimeException("Duplication: " + val);
                }
            }

            System.out.println("Adding: " + val + " to: " + itNode);

            if (itNode.data < newNode.data) {
                itNode.right = newNode;
            } else if (itNode.data > newNode.data) {
                itNode.left = newNode;
            }
        }

        return newNode;

        //System.out.println();
    }

    public void print() {
        BinaryTreePrinter.printNode(root);
    }

}
