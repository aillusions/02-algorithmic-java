package com.zalizniak.medium.tree.binary;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Binary Heap. A Binary Heap is a Binary Tree with following properties.
 * 1) It’s a complete tree (All levels are completely filled except possibly the last level and the last level has all keys as left as possible). This property of Binary Heap makes them suitable to be stored in an array.
 * 2) A Binary Heap is either Min Heap or Max Heap.
 * In a Min Binary Heap, the key at root must be minimum among all keys present in Binary Heap.
 * The same property must be recursively true for all nodes in Binary Tree.
 * Max Binary Heap is similar to MinHeap.
 */
public class MinHeapTree {

    private BinaryTreeNode root;

    public void insert(Integer value) {
        BinaryTreeNode newNode = new BinaryTreeNode(value);

        if (root == null) {
            root = newNode;
        } else {

            List<BinaryTreeNode> completeNewPath = new LinkedList<>();

            Queue<BinaryTreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                BinaryTreeNode currentNode = queue.poll();
                completeNewPath.add(currentNode);

                System.out.println("Adding: " + value + " seen: " + currentNode.data);

                if (currentNode.left == null || currentNode.right == null) {
                    break;
                }

                queue.addAll(currentNode.getChildNodes());
            }

            BinaryTreeNode parent = completeNewPath.get(completeNewPath.size() - 1);
            if (parent.left == null) {
                parent.left = newNode;
            } else if (parent.right == null) {
                parent.right = newNode;
            } else {
                parent.left = newNode;
            }


        }
    }


    public void print() {
        BinaryTreePrinter.printNode(root);
    }
}
