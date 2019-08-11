package com.zalizniak.medium.levenshtein_distance;

import java.util.List;
import java.util.stream.Collectors;

/**
 * insertions
 * deletions
 * substitutions
 */
public class MyLevenshteinDistance implements LevenshteinDistance {

    @Override
    public int getDistance(String a, String b) {

        return getDistance(a.chars().mapToObj(i -> (char) i).collect(Collectors.toList()),
                b.chars().mapToObj(i -> (char) i).collect(Collectors.toList()));
    }

    public int getDistance(List<Character> a, List<Character> b) {
        if (a.isEmpty() && b.isEmpty()) {
            return 0;
        }

        if (a.isEmpty()) {
            return 1 + getDistance(a, b.subList(1, b.size()));
        } else if (b.isEmpty()) {
            return 1 + getDistance(a.subList(1, a.size()), b);
        }

        if (a.get(0) == b.get(0)) {
            return getDistance(a.subList(1, a.size()), b.subList(1, b.size()));
        }

        return 1 + Math.min(getDistance(a.subList(1, a.size()), b), getDistance(a, b.subList(1, b.size())));
    }
}
