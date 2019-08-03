package com.zalizniak.sort;

import java.util.ArrayList;
import java.util.Comparator;

public class LargestThreeElementsInArray {

    private static final Comparator<Integer> INTEGER_COMPARATOR = (o1, o2) -> -Integer.compare(o1, o2);

    public static Integer[] findBiggestThreeNumbersBySort(int[] in) {

        final ArrayList<Integer> intermediate = new ArrayList<>();
        for (int value : in) {
            intermediate.add(value);
        }

        intermediate.sort(INTEGER_COMPARATOR);

        return intermediate.subList(0, 3).toArray(new Integer[3]);
    }

    public static Integer[] findBiggestThreeNumbersNoSort(int[] in, int biggestN) {

        Integer[] rv = new Integer[biggestN];

        int minRvIdx = 0;
        for (int i = 0; i < in.length; i++) {

            // Find minimal in array of return values
            for (int j = 0; j < biggestN; j++) {
                if (rv[j] == null) {
                    minRvIdx = j;
                    break;
                } else if (rv[j] < rv[minRvIdx]) {
                    minRvIdx = j;
                }
            }

            // Replace minimal
            if (rv[minRvIdx] == null || in[i] > rv[minRvIdx]) {
                rv[minRvIdx] = in[i];
            }
        }

        return rv;
    }
}