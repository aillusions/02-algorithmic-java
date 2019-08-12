package com.zalizniak.medium.river_sizes;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class RiverSizes {

    private final List<Integer>[] adjacentLists;
    private final Integer[] nodeValues;
    private final int totalElementsOfMatrix;
    private final int matrixWidth;
    private final int matrixHeight;


    public RiverSizes(int[][] matrix) {
        matrixHeight = matrix.length;
        matrixWidth = matrix[0].length;
        totalElementsOfMatrix = matrixWidth * matrixHeight;
        adjacentLists = new List[totalElementsOfMatrix];
        nodeValues = new Integer[totalElementsOfMatrix];

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

                System.out.println("seen idx: " + currentElementIdx + " (value: " + nodeValues[currentElementIdx] + ")" + " connected to: " + adjacentList);
            }
        }
    }

    public List<Integer> riverSizes() {


        return Arrays.asList(1);
    }
}
