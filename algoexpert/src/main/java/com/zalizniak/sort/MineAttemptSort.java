package com.zalizniak.sort;

import java.util.Arrays;

public class MineAttemptSort {

    public static Integer[] referenceImpl(Integer[] in) {
        Arrays.sort(in);
        return in;
    }

    public static Integer[] sort(Integer[] in) {
        return referenceImpl(in);
    }
}
