package com.zalizniak.medium.graph.geeksforgeeks;

import java.util.LinkedList;
import java.util.Queue;

/**
 * see directed-unweighted-predefined-graph-of-5-nodes.png
 */
public class ShortestPath {

    // directed unweighted predefined graph of 6 nodes, see
    private int[][] adjacencyLists = new int[][]{
            /*0*/ {1, 2, 5},
            /*1*/ {4},
            /*2*/ {},
            /*3*/ {1, 5},
            /*4*/ {0, 3},
            /*5*/ {2}
    };

    public int getShortestPath(int startNode, int endNode) {

        int[] distances = new int[adjacencyLists.length];

        boolean[] visited = new boolean[adjacencyLists.length];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println(startNode + " -> " + endNode + ": visited " + node);
            visited[node] = true;

            for (int i = 0; i < adjacencyLists[node].length; i++) {
                int adjacentToNode = adjacencyLists[node][i];
                if (!visited[adjacentToNode]) {
                    queue.add(adjacentToNode);
                }
            }
        }

        System.out.println();

        return 0;
    }

}
