package com.zalizniak.graph;

import java.util.*;

public class Vertex {

    public Integer label;
    public List<Vertex> vertices = new LinkedList<>();

    public Vertex(Integer label) {
        this.label = label;
    }

    public void add(Vertex... nodes) {
        vertices.addAll(Arrays.asList(nodes));
    }

    public static Set<Vertex> depthFirstTraversal(Vertex root) {
        Set<Vertex> visited = new LinkedHashSet<>();
        Stack<Vertex> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Vertex vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex v : vertex.vertices) {
                    stack.push(v);
                }
            }
        }
        return visited;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public String toString() {
        return label.toString();
    }
}
