package com.zalizniak.medium.river_sizes;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 */
public class RiverSizes {

    private final List<Integer>[] adjacentLists;
    private final List<Integer> riverNodes = new LinkedList<>();

    private final int totalElementsOfMatrix;
    private final int matrixWidth;
    private final int matrixHeight;

    public RiverSizes(int[][] matrix) {
        matrixHeight = matrix.length;
        matrixWidth = matrix[0].length;
        totalElementsOfMatrix = matrixWidth * matrixHeight;
        adjacentLists = new List[totalElementsOfMatrix];

        for (int h = 0; h < matrix.length; h++) {
            for (int w = 0; w < matrix.length; w++) {

                int currentElementIdx = (matrixWidth * h) + w;
                List<Integer> adjacentList = new LinkedList<>();
                adjacentLists[currentElementIdx] = adjacentList;
                int nodeValue = matrix[h][w];
                if (nodeValue == 0) {
                    continue;
                }

                riverNodes.add(currentElementIdx);

                if (h - 1 >= 0) {
                    if (matrix[h - 1][w] == 1) {
                        adjacentList.add((matrixWidth * (h - 1)) + w);
                    }
                }

                if (h + 1 < matrixHeight) {
                    if (matrix[h + 1][w] == 1) {
                        adjacentList.add((matrixWidth * (h + 1)) + w);
                    }
                }

                if (w - 1 >= 0) {
                    if (matrix[h][w - 1] == 1) {
                        adjacentList.add((matrixWidth * h) + (w - 1));
                    }
                }

                if (w + 1 < matrixWidth) {
                    if (matrix[h][w + 1] == 1) {
                        adjacentList.add((matrixWidth * h) + (w + 1));
                    }
                }
            }
        }
    }

    public List<Integer> riverSizes() {

        List<Integer> rv = new LinkedList<>();
        boolean[] visited = new boolean[totalElementsOfMatrix];

        Stack<Integer> stack = new Stack<>();

        for (Integer riverNode : riverNodes) {

            if (visited[riverNode]) {
                continue;
            }

            stack.add(riverNode);

            int riverSize = 0;

            while (!stack.isEmpty()) {
                int thisNodeIdx = stack.pop();
                if (visited[thisNodeIdx]) {
                    continue;
                }

                System.out.println("seen: " + thisNodeIdx);
                riverSize++;
                visited[thisNodeIdx] = true;
                List<Integer> adjacents = adjacentLists[thisNodeIdx];
                stack.addAll(adjacents);
            }
            rv.add(riverSize);
            System.out.println("riverSize: " + riverSize);
        }

        return rv;
    }
}
