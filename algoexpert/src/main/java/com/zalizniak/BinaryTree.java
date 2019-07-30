package com.zalizniak;

public class BinaryTree {

    protected BinaryTreeNode root;

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

    public static class BinaryTreeNode {
        protected String label;
        protected BinaryTreeNode leftNode;
        protected BinaryTreeNode rightNode;

        public BinaryTreeNode(String label) {
            this.label = label;
        }
    }
}
