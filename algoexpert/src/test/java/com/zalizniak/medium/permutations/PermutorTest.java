package com.zalizniak.medium.permutations;

import org.junit.Test;

import java.util.Arrays;

public class PermutorTest {

    @Test
    public void test1() {
        int[][] permutations = Permutor.permute(new int[]{1});
        for (int i = 0; i < permutations.length; i++) {
            System.out.println(Arrays.toString(permutations[i]));
        }
        System.out.println();
    }

    @Test
    public void test2() {
        int[][] permutations = Permutor.permute(new int[]{1, 2});
        for (int i = 0; i < permutations.length; i++) {
            System.out.println(Arrays.toString(permutations[i]));
        }
        System.out.println();
    }

    @Test
    public void test3() {
        int[][] permutations = Permutor.permute(new int[]{1, 2, 3});
        for (int i = 0; i < permutations.length; i++) {
            System.out.println(Arrays.toString(permutations[i]));
        }
        System.out.println();
    }

    @Test
    public void test4() {
        int[][] permutations = Permutor.permute(new int[]{1, 2, 3, 4});
        for (int i = 0; i < permutations.length; i++) {
            System.out.println(Arrays.toString(permutations[i]));
        }
        System.out.println();
    }
}
