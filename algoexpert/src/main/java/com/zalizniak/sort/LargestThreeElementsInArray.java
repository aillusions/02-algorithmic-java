package com.zalizniak.sort;

import java.util.LinkedList;

public class LargestThreeElementsInArray {

    public static int[] findBiggestThreeNumbers(int[] in) {

        LinkedList<Integer> intermediate = new LinkedList<>();
        for (int value : in) {
            intermediate.add(value);
        }

        intermediate.sort((o1, o2) -> -Integer.compare(o1, o2));

        return intermediate.subList(0, 3).stream().mapToInt(e -> e).toArray();
    }
}
