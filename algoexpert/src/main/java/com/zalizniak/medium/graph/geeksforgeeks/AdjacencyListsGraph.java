package com.zalizniak.medium.graph.geeksforgeeks;

import java.util.LinkedList;

public class AdjacencyListsGraph {

    private LinkedList<Integer>[] adj; // Adjacency Lists

    public AdjacencyListsGraph(int verticesNum) {

        adj = new LinkedList[verticesNum];

        for (int i = 0; i < verticesNum; ++i) {
            adj[i] = new LinkedList();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }
}
