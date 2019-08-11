package com.zalizniak.medium.graph;

import org.junit.Test;

public class UndirectedGraphTest {

    @Test
    public void test() {
        UndirectedUnweightedGraph graph = new UndirectedUnweightedGraph();

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);

        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
    }
}
