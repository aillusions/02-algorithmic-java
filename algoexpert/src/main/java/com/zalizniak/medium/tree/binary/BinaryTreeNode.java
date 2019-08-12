package com.zalizniak.medium.tree.binary;

import java.util.HashSet;
import java.util.Set;

public class BinaryTreeNode {
    public Integer data;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(Integer data) {
        this.data = data;
    }

    public Set<BinaryTreeNode> getChildNodes() {
        Set<BinaryTreeNode> rv = new HashSet<>();

        if (left != null) {
            rv.add(left);
        }

        if (right != null) {
            rv.add(right);
        }
        return rv;
    }


    @Override
    public String toString() {
        return data.toString();
    }
}
