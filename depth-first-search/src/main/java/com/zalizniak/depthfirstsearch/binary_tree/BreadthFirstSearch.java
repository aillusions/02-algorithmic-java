package com.zalizniak.depthfirstsearch.binary_tree;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS on a binary tree
 */
@Slf4j
public class BreadthFirstSearch {

    Node startNode;
    Node goalNode;

    public BreadthFirstSearch(Node start, Node goalNode) {
        this.startNode = start;
        this.goalNode = goalNode;
    }

    public boolean compute() {

        if (startNode.equals(goalNode)) {
            log.info("Goal Node Found!");
            log.info("startNode: " + startNode);
        }

        Queue<Node> queue = new LinkedList<>();
        //ArrayList<Node> explored = new ArrayList<>();
        queue.add(startNode);
        //explored.add(startNode);

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            if (current.equals(goalNode)) {
                //log.info("explored: " + explored);
                return true;
            } else {
                if (current.getChildren().isEmpty()) {
                    return false;
                } else {
                    queue.addAll(current.getChildren());
                }
            }
            //explored.add(current);
        }

        return false;
    }
}
