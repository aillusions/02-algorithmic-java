package com.zalizniak.medium.tree.binary;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class BinaryTreeNode {
    public Integer data;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(Integer data) {
        this.data = data;
    }

    public Set<Integer> getChildNodeValues() {
        return getChildNodes().stream().map(e -> e.data).collect(Collectors.toSet());
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
