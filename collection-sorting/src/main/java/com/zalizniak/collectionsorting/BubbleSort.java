package com.zalizniak.collectionsorting;

public class BubbleSort {

    void bubbleSort(int arr[]) {

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
}
