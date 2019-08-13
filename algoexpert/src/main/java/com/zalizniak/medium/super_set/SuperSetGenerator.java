package com.zalizniak.medium.super_set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * If S has n elements in it then P(s) will have 2^n elements
 */
public class SuperSetGenerator {

    public static Set<Set<Integer>> getSuperset(Set<Integer> in) {
        return superSet(in.toArray(new Integer[in.size()]));
    }

    private static Set<Set<Integer>> superSet(Integer[] in) {

        System.out.println("Super set of: " + Arrays.toString(in));

        Set<Set<Integer>> rv = new HashSet<>();

        if (in.length == 0) {
            return rv;
        }

        Integer[] subArray = Arrays.copyOfRange(in, 1, in.length);
        Set<Set<Integer>> subArraySuperSet = superSet(subArray);

        for (Set<Integer> subSet : subArraySuperSet) {
            Set<Integer> incl = new HashSet<>(subSet);
            Set<Integer> excl = new HashSet<>(subSet);
            incl.add(in[0]);

            rv.add(incl);
            rv.add(excl);
        }

        return rv;
    }
}
