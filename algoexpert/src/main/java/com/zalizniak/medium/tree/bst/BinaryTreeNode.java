package com.zalizniak.medium.tree.bst;

public class BinaryTreeNode {
    protected Integer data;
    protected BinaryTreeNode left;
    protected BinaryTreeNode right;

    public BinaryTreeNode(Integer data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
