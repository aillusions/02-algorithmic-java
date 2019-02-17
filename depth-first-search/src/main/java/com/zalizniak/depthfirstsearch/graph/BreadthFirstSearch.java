package com.zalizniak.depthfirstsearch.graph;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BFS Using Neighbours list (also there is Using Adjacency Matrix)
 */
@Slf4j
public class BreadthFirstSearch {

    private Queue<Node> queue;

    public BreadthFirstSearch() {
        queue = new LinkedList<>();
    }

    public void bfs(Node node) {
        queue.add(node);
        node.visited = true;

        while (!queue.isEmpty()) {

            Node element = queue.remove();
            log.info(element.data + "\t");
            List<Node> neighbours = element.getNeighbours();

            for (int i = 0; i < neighbours.size(); i++) {
                Node n = neighbours.get(i);
                if (n != null && !n.visited) {
                    queue.add(n);
                    n.visited = true;
                }
            }
        }
    }
}