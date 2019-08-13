package com.zalizniak.medium.permutations;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * The number of possible permutations grows factorially
 * By the time you have 10 elements, there are more than 3.5 million permutations
 * With factorial algorithms - computer is unable to compute more than the first dozen or so cases in any reasonable amount of time.
 */
public class Permutor {


    public static int[][] permute(int[] in) {
        int size = in.length;

        List<int[]> permutationsHolder = new LinkedList<>();

        permute(in, 0, size - 1, permutationsHolder);

        int permutationsNumber = factorialUsingForLoop(size);
        int[][] rv = new int[permutationsNumber][size];
        for (int i = 0; i < permutationsHolder.size(); i++) {
            rv[i] = permutationsHolder.get(i);
        }

        return rv;
    }

    private static void permute(int[] in, int startingIndex, int endIndex, List<int[]> holder) {
        if (startingIndex == endIndex) {
            //System.out.println(Arrays.toString(in));
            holder.add(Arrays.copyOf(in, in.length));
        } else {
            for (int i = startingIndex; i <= endIndex; i++) {
                swap(in, startingIndex, i);
                permute(in, startingIndex + 1, endIndex, holder);
                swap(in, startingIndex, i);
            }
        }
    }

    public static void swap(int[] in, int i, int j) {
        int temp = in[i];
        in[i] = in[j];
        in[j] = temp;
    }

    public static int factorialUsingForLoop(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static int factorialUsingRecursion(int n) {
        if (n <= 2) {
            return n;
        }
        return n * factorialUsingRecursion(n - 1);
    }
}
