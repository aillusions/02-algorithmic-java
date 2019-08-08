package com.zalizniak.sort;

import java.util.Arrays;

public class MineAttemptSort {

    public static Integer[] referenceImpl(Integer[] in) {
        Arrays.sort(in);
        return in;
    }

    public static Integer[] bubbleSort(Integer[] in) {
        for (int j = 0; j < in.length - 1; j++) {
            for (int i = 0; i < (in.length - j - 1); i++) {
                if (in[i] > in[i + 1]) {
                    Integer tmp = in[i];
                    in[i] = in[i + 1];
                    in[i + 1] = tmp;
                }
            }
        }

        return in;
    }
}
