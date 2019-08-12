package com.zalizniak.medium.river_sizes;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class RiverSizes {

    private final List<Integer>[] adjacentLists;
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

                int adjacencyElementIdx = w + (matrixWidth * h);
                int matrixElement = matrix[h][w];

                //if (matrixElement == 0) {
                //    continue;
                //}

                List<Integer> adjacentList = adjacentLists[adjacencyElementIdx];

                if (h - 1 >= 0) {
                    if (matrix[h - 1][w] == 1) {

                    }
                }

                if (h + 1 < matrixHeight) {
                    if (matrix[h + 1][w] == 1) {

                    }
                }

                if (w - 1 >= 0) {
                    if (matrix[h][w - 1] == 1) {

                    }
                }

                if (w + 1 < matrixWidth) {
                    if (matrix[h][w + 1] == 1) {

                    }
                }

                System.out.println("seen: " + adjacencyElementIdx + " connected to: " + adjacentList);
            }
        }
    }

    public List<Integer> riverSizes() {
        return Arrays.asList(1);
    }
}
