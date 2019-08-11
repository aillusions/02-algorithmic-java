package com.zalizniak.medium.graph.cycle;

import com.zalizniak.medium.graph.Vertex;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class GraphCycleDetector {

    public boolean hasCycle(Vertex root) {

        Set<Vertex> visited = new HashSet<>();

        Stack<Vertex> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            Vertex vertex = stack.pop();
            System.out.println("Visited: " + vertex.label);

            if (visited.contains(vertex)) {
                return true;
            }

            visited.add(vertex);

            stack.addAll(vertex.vertices);
        }

        return false;
    }
}
