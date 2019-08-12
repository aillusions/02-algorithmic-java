package com.zalizniak.medium.tree.binary;

import java.util.LinkedList;
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

            BinaryTreeNode parent = null;

            Queue<BinaryTreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                parent = queue.poll();

                System.out.println("Adding: " + value + " seen: " + parent.data);

                if (parent.left == null || parent.right == null) {
                    break;
                }

                queue.addAll(parent.getChildNodes());
            }

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
