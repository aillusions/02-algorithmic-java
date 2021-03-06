package com.zalizniak.medium.super_set;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SuperSetGeneratorTest {

    @Test
    public void testSuperSet() {
        System.out.println(superSet(new int[]{1, 2, 3}, new int[]{4, 5, 6}));
    }

    @Test
    public void testSuperSetGenerator() {
        Assert.assertEquals(superSet(new int[0], new int[]{1}, new int[]{2}, new int[]{1, 2}), SuperSetGenerator.getSuperset(new HashSet<>(Arrays.asList(1, 2))));
        Assert.assertEquals(superSet(new int[0], new int[]{1}, new int[]{2}, new int[]{3}, new int[]{1, 2}, new int[]{1, 3}, new int[]{2, 3}, new int[]{1, 2, 3}), SuperSetGenerator.getSuperset(new HashSet<>(Arrays.asList(1, 2, 3))));
    }

    private Set<Set<Integer>> superSet(int[]... subSets) {
        Set<Set<Integer>> rv = new HashSet<>();
        for (int[] subSet : subSets) {
            HashSet<Integer> inner = new HashSet<>();
            for (int i : subSet) {
                inner.add(i);
            }
            rv.add(inner);
        }
        return rv;
    }
}
