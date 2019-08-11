package com.zalizniak.medium.graph.geeksforgeeks;

import org.junit.Test;

public class AdjacencyListsGraphTest {

    @Test
    public void testAdjacencyListsGraph() {
        AdjacencyListsGraph g = new AdjacencyListsGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
    }

    @Test
    public void testBreadthFirstSearch() {

        AdjacencyListsGraph g = new AdjacencyListsGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.BFS(2);
    }
}