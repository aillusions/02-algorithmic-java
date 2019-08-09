package com.zalizniak.easy.sort;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class JavaOOTBSortsTest {

    private static final int SIZE = 1_000_000;
    private static final Integer[] ARRAY = new Integer[SIZE];

    static {
        Random RAND = new Random();
        for (int i = 0; i < SIZE; i++) {
            ARRAY[i] = RAND.nextInt();
        }
    }

    private static final List<Integer> LIST = Arrays.asList(ARRAY);

    private static final Comparator<Integer> INTEGER_COMPARATOR = (o1, o2) -> -Integer.compare(o1, o2);

    @Test
    public void shouldSortArray() {
        Arrays.sort(ARRAY, INTEGER_COMPARATOR);
    }

    @Test
    public void shouldSortArrayParallel() {
        Arrays.parallelSort(ARRAY, INTEGER_COMPARATOR);
    }

    @Test
    public void shouldSortList() {
        LIST.sort(INTEGER_COMPARATOR);
    }

    @Test
    public void shouldSortListParallel() {
        LIST.parallelStream().sorted(INTEGER_COMPARATOR).collect(Collectors.toList());
    }
}
