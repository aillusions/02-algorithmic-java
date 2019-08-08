package com.zalizniak.tree;

public class BinarySearchTree {

    protected BinarySearchTreeNode root;

    public BinarySearchTree(BinarySearchTreeNode root) {
        this.root = root;
    }

    public static class BinarySearchTreeNode {
        protected String label;
        protected BinarySearchTreeNode leftNode;
        protected BinarySearchTreeNode rightNode;

        public BinarySearchTreeNode(String label) {
            this.label = label;
        }
    }
}
