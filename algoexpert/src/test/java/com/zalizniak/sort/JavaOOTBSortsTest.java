package com.zalizniak.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JavaOOTBSortsTest {

    private static final Integer[] ARRAY = new Integer[]{1, 5, 7, 66, 88, 89, 123, 200, 255, 300000000, 1, 21, 2, 3, 22, 4, 5, 23, 6, 7, 24, 8, 9, 25, 200000000, 10, 11, 26, 12, 13, 27, 14, 15, 28, 16, 17, 29, 18, 30, 19, 100000000, 1, 5, 7, 66, 88, 89, 123, 200, 255};
    private static final List<Integer> LIST = Arrays.asList(ARRAY);

    private static final Comparator<Integer> INTEGER_COMPARATOR = (o1, o2) -> -Integer.compare(o1, o2);

    @Test
    public void shouldSortArray() {
        Arrays.sort(ARRAY, INTEGER_COMPARATOR);
    }

    @Test
    public void shouldSortList() {
        Collections.sort(LIST, INTEGER_COMPARATOR);
    }
}
