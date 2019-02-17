package com.zalizniak.collectionsorting;

import java.util.stream.IntStream;

public class BubbleSort {

    static void bubbleSort(int arr[]) {

        for (int idx = 0; idx < arr.length - 1; idx++) {

            for (int innerIdx = 0; innerIdx < arr.length - idx - 1; innerIdx++) {

                if (arr[innerIdx] > arr[innerIdx + 1]) {
                    int temp = arr[innerIdx];
                    arr[innerIdx] = arr[innerIdx + 1];
                    arr[innerIdx + 1] = temp;
                }
            }
        }
    }

    /**
     * time complexity O(n^2)
     * space complexity O(1)
     */
    static void bubbleSortStream(Integer[] arr) {
        IntStream.range(0, arr.length - 1)
                .flatMap(i -> IntStream.range(1, arr.length - i))
                .forEach(j -> {
                    if (arr[j - 1] > arr[j]) {
                        int temp = arr[j];
                        arr[j] = arr[j - 1];
                        arr[j - 1] = temp;
                    }
                });
    }
}
