package com.zalizniak.medium.levenshtein_distance;

import java.util.Arrays;
import java.util.List;

public class MyLevenshteinDistance implements LevenshteinDistance {

    @Override
    public int getDistance(String a, String b) {
        return getDistance(new StringBuilder(a), new StringBuilder(b), Arrays.asList("i", "d", "s"));
    }

    public int getDistance(StringBuilder basis, StringBuilder modifier, List<String> operations) {
        if (basis.equals(modifier)) {
            return 0;
        }

        return 1;
    }
}
