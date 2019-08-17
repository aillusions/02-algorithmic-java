package com.zalizniak.hard.red_black_tree;

import com.zalizniak.medium.tree.binary.BinaryTreeNode;
import com.zalizniak.medium.tree.binary.BinaryTreePrinter;

import java.util.LinkedList;
import java.util.List;

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
        root = deleteRec(root, value);
        System.out.println("Deleted: " + value);
    }

    /**
     * If n has no children, we only have to remove n from the tree.
     * If n has a single child, we remove n and connect its parent to its child.
     * If n has two children, we need to :
     * - Find the smallest node that is larger than n, call it m.
     * - Remove m from the tree (if you have reached this case then m will always have no left child, though I’ll leave the proof to the reader), so we apply one or the other of the above cases to do this.
     * - Replace the value of n with m.
     */
    protected RedBlackNode deleteRec(BinaryTreeNode startRoot, int value) {
        if (startRoot == null) {
            return null;
        }

        if (value < startRoot.data) {
            startRoot.left = deleteRec(startRoot.left, value);
        } else if (value > startRoot.data) {
            startRoot.right = deleteRec(startRoot.right, value);
        } else {
            if (startRoot.left == null) {
                return (RedBlackNode) startRoot.right;
            } else if (startRoot.right == null) {
                return (RedBlackNode) startRoot.left;
            }

            startRoot.data = minValue(startRoot.right);  // node with two children: Get the inorder successor (smallest in the right subtree)

            startRoot.right = deleteRec(startRoot.right, startRoot.data);
        }

        return (RedBlackNode) startRoot;
    }

    protected int minValue(BinaryTreeNode root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
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

    public List<Integer> inOrder() {
        List<Integer> rv = new LinkedList<>();
        inOrder(root, rv);
        return rv;
    }

    public void inOrder(BinaryTreeNode node, List<Integer> tracker) {

        if (node == null) {
            return;
        }

        inOrder(node.left, tracker);

        tracker.add(node.data);

        inOrder(node.right, tracker);
    }

    public void print() {
        BinaryTreePrinter.printNode(root);
    }
}
