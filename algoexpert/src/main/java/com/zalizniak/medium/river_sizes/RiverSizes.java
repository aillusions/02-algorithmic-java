package com.zalizniak.medium.river_sizes;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 */
public class RiverSizes {

    private final List<Integer>[] adjacentLists;
    private final int[] nodeValues;
    private final int totalElementsOfMatrix;
    private final int matrixWidth;
    private final int matrixHeight;

    public RiverSizes(int[][] matrix) {
        matrixHeight = matrix.length;
        matrixWidth = matrix[0].length;
        totalElementsOfMatrix = matrixWidth * matrixHeight;
        adjacentLists = new List[totalElementsOfMatrix];
        nodeValues = new int[totalElementsOfMatrix];

        for (int h = 0; h < matrix.length; h++) {
            for (int w = 0; w < matrix.length; w++) {

                int currentElementIdx = (matrixWidth * h) + w;
                List<Integer> adjacentList = new LinkedList<>();
                adjacentLists[currentElementIdx] = adjacentList;
                nodeValues[currentElementIdx] = matrix[h][w];

                if (h - 1 >= 0) {
                    //if (matrix[h - 1][w] == 1) {
                    adjacentList.add((matrixWidth * (h - 1)) + w);
                    //}
                }

                if (h + 1 < matrixHeight) {
                    //if (matrix[h + 1][w] == 1) {
                    adjacentList.add((matrixWidth * (h + 1)) + w);
                    //}
                }

                if (w - 1 >= 0) {
                    //if (matrix[h][w - 1] == 1) {
                    adjacentList.add((matrixWidth * h) + (w - 1));
                    //}
                }

                if (w + 1 < matrixWidth) {
                    //if (matrix[h][w + 1] == 1) {
                    adjacentList.add((matrixWidth * h) + (w + 1));
                    //}
                }

                //System.out.println("seen idx: " + currentElementIdx + " (value: " + nodeValues[currentElementIdx] + ")" + " connected to: " + adjacentList);
            }
        }
    }

    public List<Integer> riverSizes() {

        boolean[] visited = new boolean[totalElementsOfMatrix];
        Stack<Integer> stack = new Stack<>();
        stack.add(0);

        boolean isInRiver = false;
        while (!stack.isEmpty()) {
            int thisNodeIdx = stack.pop();
            if (visited[thisNodeIdx]) {
                continue;
            }

            System.out.println("Seen: [" + nodeValues[thisNodeIdx] + "] ");
            visited[thisNodeIdx] = true;
            List<Integer> adjacents = adjacentLists[thisNodeIdx];
            boolean adjacentsInRiver = false;
            for (int i = 0; i < adjacents.size(); i++) {
                int adjacentIdx = adjacents.get(i);
                if (nodeValues[adjacentIdx] == 1) {
                    adjacentsInRiver = true;
                    break;
                }
            }

            if (isInRiver != adjacentsInRiver) {
                System.out.println("River breaks: " + thisNodeIdx);
            }

            isInRiver = adjacentsInRiver;
            stack.addAll(adjacents);
        }

        return Arrays.asList(1);
    }
}
