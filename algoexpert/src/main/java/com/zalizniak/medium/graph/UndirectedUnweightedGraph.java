package com.zalizniak.medium.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UndirectedUnweightedGraph {

    private final HashMap<Integer, Set<Integer>> adjacencyMap;

    public UndirectedUnweightedGraph() {
        this.adjacencyMap = new HashMap<>();
    }

    public void addVertex(Integer v) {
        if (this.adjacencyMap.containsKey(v)) {
            throw new IllegalArgumentException("Vertex already exists.");
        }
        this.adjacencyMap.put(v, new HashSet<Integer>());
    }

    public void removeVertex(Integer v) {
        if (!this.adjacencyMap.containsKey(v)) {
            throw new IllegalArgumentException("Vertex doesn't exist.");
        }

        this.adjacencyMap.remove(v);

        for (Integer u : this.getAllVertices()) {
            this.adjacencyMap.get(u).remove(v);
        }
    }

    public void addEdge(Integer v, Integer u) {
        if (!this.adjacencyMap.containsKey(v) || !this.adjacencyMap.containsKey(u)) {
            throw new IllegalArgumentException();
        }

        this.adjacencyMap.get(v).add(u);
        this.adjacencyMap.get(u).add(v);
    }

    public void removeEdge(Integer v, Integer u) {
        if (!this.adjacencyMap.containsKey(v) || !this.adjacencyMap.containsKey(u)) {
            throw new IllegalArgumentException();
        }

        this.adjacencyMap.get(v).remove(u);
        this.adjacencyMap.get(u).remove(v);
    }

    public boolean isAdjacent(Integer v, Integer u) {
        return this.adjacencyMap.get(v).contains(u);
    }

    public Iterable<Integer> getNeighbors(Integer v) {
        return this.adjacencyMap.get(v);
    }

    public Iterable<Integer> getAllVertices() {
        return this.adjacencyMap.keySet();
    }
}
