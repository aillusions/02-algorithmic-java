package com.zalizniak.medium.levenshtein_distance;

/**
 * 3^n - exponential
 */
public class MyLevenshteinDistance implements LevenshteinDistance {

    @Override
    public int getDistance(String a, String b) {

        if (a.isEmpty()) {
            return b.length();
        } else if (b.isEmpty()) {
            return a.length();
        }

        if (a.charAt(0) == b.charAt(0)) {
            return getDistance(a.substring(1), b.substring(1));
        }

        int d1 = getDistance(a.substring(1), b); // removal / insertion
        int d2 = getDistance(a, b.substring(1)); // removal / insertion
        int d3 = getDistance(a.substring(1), b.substring(1)); // substitutions

        return 1 + Math.min(d1, Math.min(d2, d3));
    }

}
