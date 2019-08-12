package com.zalizniak.medium.tree.binary.lowest_common_ancestor;

import com.zalizniak.medium.tree.binary.BinaryTreeNode;

import java.util.*;

public class LowestCommonAncestor {

    public int getLowestCommonAncestor(BinaryTreeNode treeRoot, int a, int b) {

        Set<Integer> searchedNodes = new HashSet<>(Arrays.asList(a, b));

        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.add(treeRoot);

        List<Integer> traversalPath = new LinkedList<>();
        List<List<Integer>> pathFromRootToX = new LinkedList<>();

        while (!stack.isEmpty()) {

            BinaryTreeNode currentNode = stack.pop();
            int nodeKey = currentNode.data;
            traversalPath.add(nodeKey);

            System.out.print("Visited: " + nodeKey);

            if (searchedNodes.contains(currentNode.left.data)) {
                pathFromRootToX.add(new LinkedList<>(traversalPath));
            }

            if (searchedNodes.contains(currentNode.right.data)) {
                pathFromRootToX.add(new LinkedList<>(traversalPath));
            }

            stack.addAll(currentNode.getChildNodes());

            System.out.println();

            if (pathFromRootToX.size() == 2) {
                break;
            }
        }

        List<Integer> path1 = pathFromRootToX.get(0);
        List<Integer> path2 = pathFromRootToX.get(1);

        System.out.println("path1: " + path1);
        System.out.println("path2: " + path2);

        int i = 0;
        while (true) {
            if (i >= path1.size()) {
                return path1.get(i - 1);
            }

            if (i >= path2.size()) {
                return path2.get(i - 1);
            }

            i++;
        }
    }
}
