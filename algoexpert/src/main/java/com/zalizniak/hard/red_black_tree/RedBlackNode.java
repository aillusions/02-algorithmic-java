package com.zalizniak.hard.red_black_tree;

import com.zalizniak.medium.tree.binary.BinaryTreeNode;

public class RedBlackNode extends BinaryTreeNode {

    boolean black;

    RedBlackNode parent;

    public RedBlackNode(Integer data) {
        super(data);
    }

    public void setBlack() {
        black = true;
    }

    public void setRed() {
        black = false;
    }

    public boolean isBlack() {
        return black;
    }

    public boolean isRed() {
        return !black;
    }

    @Override
    public String toString() {
        return super.toString() + " [" + (black ? 'b' : 'r') + "]";
    }
}
