package com.zalizniak.depthfirstsearch.graph;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class BreadthFirstSearchTest {

    @Test
    public void testSearch() {

        Node node10 = new Node(10);
        Node node20 = new Node(20);
        Node node30 = new Node(30);
        Node node40 = new Node(40);
        Node node50 = new Node(50);
        Node node60 = new Node(60);
        Node node70 = new Node(70);

        node40.addNeighbours(node10, node20);
        node10.addNeighbours(node30);
        node20.addNeighbours(node10, node30, node60, node50);
        node30.addNeighbours(node60);
        node60.addNeighbours(node70);
        node50.addNeighbours(node70);

        log.info("The BFS traversal of the graph is ");

        BreadthFirstSearch bfsExample = new BreadthFirstSearch();
        bfsExample.bfs(node40);
    }
}
