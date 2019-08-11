package com.zalizniak.medium.graph;

import java.util.ArrayList;
import java.util.List;

public class UndirectedEdgeCentricGraph {

    // adjacency list
    private final List<List<Integer>> adj = new ArrayList<>();

    public UndirectedEdgeCentricGraph(List<Edge> edges) {

        for (int i = 0; i < edges.size(); i++) {
            adj.add(i, new ArrayList<>());
        }

        for (Edge current : edges) {
            adj.get(current.src).add(current.dest);

            // for undirected graph - allocate new node in adjacency List from dest to src
            adj.get(current.dest).add(current.src);
        }
    }

    public void printGraph(UndirectedEdgeCentricGraph graph) {
        int src = 0;
        int n = graph.adj.size();

        while (src < n) {
            for (int dest : graph.adj.get(src)) {
                System.out.print("(" + src + " --> " + dest + ")\t");
            }

            System.out.println();
            src++;
        }
    }

    static class Edge {
        int src, dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
}
