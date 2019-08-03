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

    public static Integer[] findBiggestThreeNumbersNoSort(int[] in) {

        Integer[] rv = new Integer[]{
                Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE
        };

        int minRvIdx = 0;
        for (int i = 0; i < in.length; i++) {

            // Find minimal in array of return values
            for (int j = 0; j < 3; j++) {
                if (rv[j] < rv[minRvIdx]) {
                    minRvIdx = j;
                }
            }

            // Replace minimal
            if (in[i] > rv[minRvIdx]) {
                rv[minRvIdx] = in[i];
            }
        }

        return rv;
    }

    public static Integer[] findBiggestThreeNumbersNoSort2(int[] in) {

        int i, first, second, third;
        third = first = second = Integer.MIN_VALUE;

        for (i = 0; i < in.length; i++) {
            if (in[i] > first) {
                third = second;
                second = first;
                first = in[i];
            } else if (in[i] > second) {
                third = second;
                second = in[i];
            } else if (in[i] > third) {
                third = in[i];
            }
        }

        return new Integer[]{
                first, second, third
        };
    }
}