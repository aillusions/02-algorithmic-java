package com.zalizniak.medium.tree.binary;

public class BinaryTreeNode {
    public Integer data;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(Integer data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
