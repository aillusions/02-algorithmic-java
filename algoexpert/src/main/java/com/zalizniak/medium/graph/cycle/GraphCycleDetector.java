package com.zalizniak.medium.graph.cycle;

import com.zalizniak.medium.graph.Vertex;

import java.util.Stack;

public class GraphCycleDetector {

    public boolean hasCycle(Vertex root) {

        Stack<Vertex> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            Vertex vertex = stack.pop();
            stack.addAll(vertex.vertices);

            System.out.println("Visited: " + vertex.label);
        }

        return false;
    }
}
