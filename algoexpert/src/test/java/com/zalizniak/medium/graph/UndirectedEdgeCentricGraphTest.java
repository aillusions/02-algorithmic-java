package com.zalizniak.medium.graph;

import org.junit.Test;

import java.util.Arrays;

public class UndirectedEdgeCentricGraphTest {

    @Test
    public void test() {
        // construct graph from given list of edges
        UndirectedEdgeCentricGraph graph = new UndirectedEdgeCentricGraph(
                Arrays.asList(
                        new UndirectedEdgeCentricGraph.Edge(0, 1),
                        new UndirectedEdgeCentricGraph.Edge(1, 2),
                        new UndirectedEdgeCentricGraph.Edge(2, 0),
                        new UndirectedEdgeCentricGraph.Edge(2, 1),
                        new UndirectedEdgeCentricGraph.Edge(3, 2),
                        new UndirectedEdgeCentricGraph.Edge(4, 5),
                        new UndirectedEdgeCentricGraph.Edge(5, 4)
                ));

        // print adjacency list representation of the graph
        graph.printGraph(graph);
    }
}
