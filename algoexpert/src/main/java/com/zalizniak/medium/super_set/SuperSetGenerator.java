package com.zalizniak.medium.super_set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * If S has n elements in it then P(s) will have 2^n elements
 */
public class SuperSetGenerator {

    public static Set<Set<Integer>> getSuperset(Set<Integer> in) {
        return superSet(new HashSet<>(in));
    }

    private static Set<Set<Integer>> superSet(Set<Integer> in) {

        System.out.println("Super set of: " + in.toString());

        Set<Set<Integer>> rv = new HashSet<>();

        if (in.isEmpty()) {
            rv.add(new HashSet<>());
            return rv;
        }

        Iterator<Integer> it = in.iterator();
        Integer thisVariable = it.next();
        it.remove();

        Set<Set<Integer>> subArraySuperSet = superSet(in);

        for (Set<Integer> subSet : subArraySuperSet) {
            Set<Integer> incl = new HashSet<>(subSet);
            Set<Integer> excl = new HashSet<>(subSet);
            incl.add(thisVariable);
            rv.add(incl);
            rv.add(excl);
        }

        return rv;
    }
}
