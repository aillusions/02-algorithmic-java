package com.zalizniak.medium.graph.geeksforgeeks;

import java.util.LinkedList;
import java.util.Queue;

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

    public void BFS(int start) {
        boolean[] visited = new boolean[adj.length];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            if (visited[vertex]) {
                continue;
            }
            visited[vertex] = true;
            queue.addAll(adj[vertex]);

            System.out.println("Visited: " + vertex);
        }
    }
}
