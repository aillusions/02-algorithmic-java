package com.zalizniak.medium.tree.binary.lowest_common_ancestor;

import com.zalizniak.medium.tree.binary.BinaryTreeNode;

import java.util.Stack;

public class LowestCommonAncestor {

    public int getLowestCommonAncestor(BinaryTreeNode treeRoot, int of, int andOf) {

        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.add(treeRoot);

        while (!stack.isEmpty()) {
            BinaryTreeNode currentNode = stack.pop();
            int nodekey = currentNode.data;
            System.out.print("Visited: " + nodekey);

            if (nodekey == of || nodekey == andOf) {
                System.out.println(" - one of sub-nodes");
            } else {
                System.out.println();
            }

            stack.addAll(currentNode.getChildNodes());
        }

        return -1;
    }
}
