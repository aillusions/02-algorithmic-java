package com.zalizniak.medium.graph.geeksforgeeks;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * see directed-unweighted-predefined-graph-of-5-nodes.png
 */
public class ShortestPath {


    private int[][] adjacencyLists;

    public ShortestPath(int[][] adjacencyLists) {
        this.adjacencyLists = adjacencyLists;
    }

    public int getShortestPath(int startNode, int endNode) {

        boolean isRouteFound = false;
        boolean[] visited = new boolean[adjacencyLists.length];
        int[] distances = new int[adjacencyLists.length];
        int[] prevNodes = new int[adjacencyLists.length];

        for (int i = 0; i < distances.length; i++) {
            visited[i] = false;
            distances[i] = -1;
            prevNodes[i] = -1;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        distances[startNode] = 0;
        visited[startNode] = true;

        while (!queue.isEmpty() && !isRouteFound) {
            int polledNode = queue.poll();

            for (int i = 0; i < adjacencyLists[polledNode].length; i++) {
                int adjacentNode = adjacencyLists[polledNode][i];

                if (!visited[adjacentNode]) {

                    distances[adjacentNode] = distances[polledNode] + 1;
                    prevNodes[adjacentNode] = polledNode;

                    if (adjacentNode == endNode) {
                        isRouteFound = true;
                        break;
                    }

                    visited[adjacentNode] = true;
                    queue.add(adjacentNode);
                }
            }
        }

        List<Integer> path = new LinkedList<>();
        int prevNode = endNode;
        path.add(prevNode);
        while (prevNodes[prevNode] != -1) {
            prevNode = prevNodes[prevNode];
            path.add(prevNode);
        }

        Collections.reverse(path);
        System.out.println(startNode + " -> " + endNode + " path: " + path);
        System.out.println();

        return distances[endNode];
    }

}
