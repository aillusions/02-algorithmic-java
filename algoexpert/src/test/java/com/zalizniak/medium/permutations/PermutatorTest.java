package com.zalizniak.medium.permutations;

import org.junit.Test;

import java.util.Arrays;

public class PermutatorTest {

    @Test
    public void test1() {
        int[][] permutations = Permutator.permutate(new int[]{1});
        for (int i = 0; i < permutations.length; i++) {
            System.out.println(Arrays.toString(permutations[i]));
        }
    }

    @Test
    public void test2() {
        int[][] permutations = Permutator.permutate(new int[]{1, 2});
        for (int i = 0; i < permutations.length; i++) {
            System.out.println(Arrays.toString(permutations[i]));
        }
    }

    @Test
    public void test3() {
        int[][] permutations = Permutator.permutate(new int[]{1, 2, 3});
        for (int i = 0; i < permutations.length; i++) {
            System.out.println(Arrays.toString(permutations[i]));
        }
    }

    @Test
    public void test4() {
        int[][] permutations = Permutator.permutate(new int[]{1, 2, 3, 4});
        for (int i = 0; i < permutations.length; i++) {
            System.out.println(Arrays.toString(permutations[i]));
        }
    }
}
